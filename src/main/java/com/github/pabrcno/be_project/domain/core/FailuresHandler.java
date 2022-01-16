package com.github.pabrcno.be_project.domain.core;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class FailuresHandler {
    private static final Logger LOGGER = LogManager.getLogger(FailuresHandler.class);
        
        private static void logError(Exception e) {
            LOGGER.error("Error: " + e.getMessage());
        }

        @ResponseBody
        @ExceptionHandler(FirstApplicationException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        ErrorMessage handleFirstApplicationException(FirstApplicationException e) {
            logError(e);
            return new ErrorMessage(e.getMessage());
        }

}
