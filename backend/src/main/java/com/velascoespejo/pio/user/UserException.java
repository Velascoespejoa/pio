package com.velascoespejo.pio.user;

import org.springframework.http.HttpStatus;


import lombok.Getter;

@Getter
public class UserException extends RuntimeException {
    private final HttpStatus status;

    public UserException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    
}