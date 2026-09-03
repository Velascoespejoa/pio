package com.velascoespejo.pio.post;

import org.springframework.http.HttpStatus;


import lombok.Getter;

@Getter
public class PostException extends RuntimeException {
    private final HttpStatus status;

    public PostException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    
}
