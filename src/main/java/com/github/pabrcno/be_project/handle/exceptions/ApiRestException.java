package com.github.pabrcno.be_project.handle.exceptions;


public class ApiRestException extends Exception {

    private String message;

    public ApiRestException(String message) {
        super(message);
    }

}
