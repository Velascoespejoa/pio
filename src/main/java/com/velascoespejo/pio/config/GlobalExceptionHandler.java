package com.velascoespejo.pio.config;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.velascoespejo.pio.post.PostException;
//import com.velascoespejo.pio.post.PostException;
import com.velascoespejo.pio.user.UserException;

@ControllerAdvice
public class GlobalExceptionHandler {

	//User
    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleUserException(UserException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
        
    //Post
    @ExceptionHandler(PostException.class)
    public ResponseEntity<String> handlePostException(PostException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
    
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
            .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
    
}