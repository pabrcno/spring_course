package com.github.pabrcno.be_project.helpers.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterLogger {
    private static final Logger LOGGER = LogManager.getLogger(AfterLogger.class);




}
