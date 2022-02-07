package com.github.pabrcno.be_project.helpers.verifiers;

import com.github.pabrcno.be_project.domain.customers.Customer;
import com.github.pabrcno.be_project.handle.exceptions.ApiRestException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class BeforeVerifier {
    
    @Before("@annotation(com.github.pabrcno.be_project.domain.core.annotations.VerifyCustomer)")
    public void verifyCustomer(JoinPoint jp) throws ApiRestException {
        log.info("Before VerifyCustomer annotation: " + ((Customer) jp.getSignature()).getEmail());
        var args = jp.getArgs();
        Customer customer = (Customer) args[0];
        if (customer == null) {
            throw new ApiRestException( "Customer is null");
        }

        if (customer.getEmail() == null || customer.getEmail().isEmpty()) {
            throw new ApiRestException("customer Email is null");
        }

        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            throw new ApiRestException("customer password is null");
        }
    }        

    @Before("@annotation(com.github.pabrcno.be_project.domain.core.annotations.VerifyProduct)")
    public void verifyProduct(JoinPoint jp) throws ApiRestException {
        log.info("Before VerifyProduct annotation: " + jp.getSignature().getName());
        var args = jp.getArgs();
        var product = (String) args[0];
        if (product == null || product.isEmpty()) {
            throw new ApiRestException("product is null");
        }
    }
}
