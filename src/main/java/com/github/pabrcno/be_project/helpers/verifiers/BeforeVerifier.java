package com.github.pabrcno.be_project.helpers.verifiers;

import com.github.pabrcno.be_project.domain.core.FirstApplicationException;
import com.github.pabrcno.be_project.domain.customers.Customer;

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
    public void verifyCustomer(JoinPoint jp) {
        log.info("Before VerifyCustomer annotation: " + jp.getSignature().getName());
        var args = jp.getArgs();
        Customer customer = (Customer) args[0];
        if (customer == null) {
            throw new FirstApplicationException("customer is null");
        }

        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new FirstApplicationException("customer name is null");
        }

        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            throw new FirstApplicationException("customer password is null");
        }
    }        

    @Before("@annotation(com.github.pabrcno.be_project.domain.core.annotations.VerifyProduct)")
    public void verifyProduct(JoinPoint jp) {
        log.info("Before VerifyProduct annotation: " + jp.getSignature().getName());
        var args = jp.getArgs();
        var product = (String) args[0];
        if (product == null || product.isEmpty()) {
            throw new FirstApplicationException("product is null");
        }
    }
}
