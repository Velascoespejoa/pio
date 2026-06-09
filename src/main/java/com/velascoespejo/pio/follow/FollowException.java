package com.velascoespejo.pio.follow;

import org.springframework.http.HttpStatus;


import lombok.Getter;

@Getter
public class FollowException extends RuntimeException {
    private final HttpStatus status;

    public FollowException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    
}
