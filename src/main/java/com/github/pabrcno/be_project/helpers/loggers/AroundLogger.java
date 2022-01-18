package com.github.pabrcno.be_project.helpers.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundLogger {
    private static final Logger LOGGER = LogManager.getLogger(AroundLogger.class);

    // log around all methods in the ICustomersService interface
    // except the ones that are annotated with @Delete or @Update
    @Around("execution(* com.github.pabrcno.be_project.domain.customers.ICustomersService.*(..)) && !@annotation(com.github.pabrcno.be_project.domain.core.annotations.Delete) && !@annotation(com.github.pabrcno.be_project.domain.core.annotations.Update)")
    public Object logAround(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //log starting and ending time of the method
        LOGGER.info("Starting: " + proceedingJoinPoint.getSignature().getName());
        LOGGER.info("With arguments: " + proceedingJoinPoint.getArgs());
        final long startTime = System.currentTimeMillis();
        final Object result = proceedingJoinPoint.proceed();
        final long endTime = System.currentTimeMillis();
        LOGGER.info("Ending: " + proceedingJoinPoint.getSignature().getName());
        LOGGER.info("Execution time: " + (endTime - startTime) + " ms");
        return result;
    }

    // log around all methods in the IProductsService interface

    @Around("execution(* com.github.pabrcno.be_project.domain.products.IProductsService.*(..))")
    public Object logAroundProducts(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //log starting and ending time of the method
        LOGGER.info("Starting: " + proceedingJoinPoint.getSignature().getName());
        LOGGER.info("With arguments: " + proceedingJoinPoint.getArgs());
        final long startTime = System.currentTimeMillis();
        final Object result = proceedingJoinPoint.proceed();
        final long endTime = System.currentTimeMillis();
        LOGGER.info("Ending: " + proceedingJoinPoint.getSignature().getName());
        LOGGER.info("Execution time: " + (endTime - startTime) + " ms");
        return result;
    }
}
