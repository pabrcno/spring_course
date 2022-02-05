package com.github.pabrcno.be_project.helpers.loggers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AroundLogger {
    
    // log around all methods in the ICustomersService interface
    
    @Around("execution(* com.github.pabrcno.be_project.domain.customers.ICustomersService.*(..))")
    public Object logAround(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //log starting and ending time of the method
        log.info("Starting: " + proceedingJoinPoint.getSignature().getName());
        log.info("With arguments: " + proceedingJoinPoint.getArgs());
        final long startTime = System.currentTimeMillis();
        final Object result = proceedingJoinPoint.proceed();
        final long endTime = System.currentTimeMillis();
        log.info("Ending: " + proceedingJoinPoint.getSignature().getName());
        log.info("Execution time: " + (endTime - startTime) + " ms");
        return result;
    }

    // log around all methods in the IProductsService interface

    @Around("execution(* com.github.pabrcno.be_project.domain.products.IProductsService.*(..))")
    public Object logAroundProducts(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //log starting and ending time of the method
        log.info("Starting: " + proceedingJoinPoint.getSignature().getName());
        log.info("With arguments: " + proceedingJoinPoint.getArgs());
        final long startTime = System.currentTimeMillis();
        final Object result = proceedingJoinPoint.proceed();
        final long endTime = System.currentTimeMillis();
        log.info("Ending: " + proceedingJoinPoint.getSignature().getName());
        log.info("Execution time: " + (endTime - startTime) + " ms");
        return result;
    }
}
