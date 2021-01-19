package com.controlapp.acontrol.exception;

public class UserNotFoundException extends AbstractRuntimeExceptionWithFieldName {

    public UserNotFoundException(String message, String fieldName) {
        super(message, fieldName);
    }
}
