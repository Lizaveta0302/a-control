package com.controlapp.acontrol.web.handler;

import com.controlapp.acontrol.dto.SimpleResponse;
import com.controlapp.acontrol.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionInfoHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<SimpleResponse> handleNotFound(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(SimpleResponse.builder()
                        .withPropertyName(e.getFieldName())
                        .withPropertyValue(e.getMessage())
                        .build());
    }
}
