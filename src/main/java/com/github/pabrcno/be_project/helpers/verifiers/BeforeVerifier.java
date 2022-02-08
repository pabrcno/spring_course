package com.github.pabrcno.be_project.helpers.verifiers;

import com.github.pabrcno.be_project.domain.cart.CartProduct;
import com.github.pabrcno.be_project.domain.cart.CartRequest;
import com.github.pabrcno.be_project.domain.customers.Customer;
import com.github.pabrcno.be_project.domain.products.Product;
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
        var product = (Product) args[0];
        if (product == null) {
            throw new ApiRestException( "Product is null");
        }

        if (product.getName() == null || product.getName().isEmpty()) {
            throw new ApiRestException("product name is null");
        }

        if (product.getPrice() == 0) {
            throw new ApiRestException("product price is null");
        }

        if (product.getDescription() == null || product.getDescription().isEmpty()) {
            throw new ApiRestException("product description is null");
        }

        if (product.getCategory() == null || product.getCategory().isEmpty()) {
            throw new ApiRestException("product category is null");
        }


    }

    @Before("@annotation(com.github.pabrcno.be_project.domain.core.annotations.VerifyCart)")
    public void verifyCart(JoinPoint jp) throws ApiRestException {
        log.info("Before VerifyCart annotation: " + jp.getSignature().getName());
        var args = jp.getArgs();
        CartRequest cart = (CartRequest)args[0];
        if (cart == null) {
            throw new ApiRestException("cart is null");
        }
        if (cart.getCustomerId() == null || cart.getCustomerId().isEmpty()) {
            throw new ApiRestException("cart customerId is null");
        }
        
        if (cart.getDeliverAddress() == null || cart.getDeliverAddress().isEmpty()) {
            throw new ApiRestException("cart deliverAddress is null");
        }
        
    }


    @Before("@annotation(com.github.pabrcno.be_project.domain.core.annotations.VerifyCartProduct)")
    public void verifyCartProduct(JoinPoint jp) throws ApiRestException {
        log.info("Before VerifyCartProduct annotation: " + jp.getSignature().getName());
        var args = jp.getArgs();
        var cartProduct = (CartProduct) args[1];
        if (cartProduct == null) {
            throw new ApiRestException("cartProduct is null");
        }
        if (cartProduct.getProductId() == null || cartProduct.getProductId().isEmpty()) {
            throw new ApiRestException("cartProduct productId is null");
        }
        if (cartProduct.getQuantity() == null) {
            throw new ApiRestException("cartProduct quantity is null");
        }
    }
}
