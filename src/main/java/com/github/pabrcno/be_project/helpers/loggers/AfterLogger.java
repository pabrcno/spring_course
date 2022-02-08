package com.github.pabrcno.be_project.helpers.loggers;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AfterLogger {
        
    @After("@annotation(com.github.pabrcno.be_project.domain.core.annotations.Delete)")
    public void logAfterDelete(JoinPoint jp) {
        log.info("After Delete annotation: " + jp.getSignature().getName());
    }
    @After("@annotation(com.github.pabrcno.be_project.domain.core.annotations.Update)")
    public void logAfterUpdate(JoinPoint jp) {
        log.info("After Update annotation: " + jp.getSignature().getName());
    }
}
