package com.github.pabrcno.be_project.helpers.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterLogger {
    private static final Logger LOGGER = LogManager.getLogger(AfterLogger.class);
    
    @After("@annotation(com.github.pabrcno.be_project.domain.core.annotations.Delete)")
    public void logAfterDelete(JoinPoint jp) {
        LOGGER.info("After Delete annotation: " + jp.getSignature().getName());
    }
    @After("@annotation(com.github.pabrcno.be_project.domain.core.annotations.Update)")
    public void logAfterUpdate(JoinPoint jp) {
        LOGGER.info("After Update annotation: " + jp.getSignature().getName());
    }
}
