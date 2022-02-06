package com.github.pabrcno.be_project.handle.exceptions;


public class ApiRestTokenException extends Exception {

    private String message;

    public ApiRestTokenException(String message) {
        super(message);
    }

}
