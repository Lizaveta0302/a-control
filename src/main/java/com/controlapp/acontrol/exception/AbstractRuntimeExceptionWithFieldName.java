package com.controlapp.acontrol.exception;


import lombok.Getter;

@Getter
public class AbstractRuntimeExceptionWithFieldName extends RuntimeException {

    private String fieldName;

    public AbstractRuntimeExceptionWithFieldName(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }
}
