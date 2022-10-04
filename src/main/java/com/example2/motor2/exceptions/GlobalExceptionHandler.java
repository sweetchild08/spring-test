package com.example2.motor2.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example2.motor2.Web.ResponseEntityBuilder;
import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(
            ResourceNotFoundException ex) {
        
        List<String> details = new ArrayList<String>();
        details.add("Resource Not Found");
        
        ApiError err = new ApiError(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND, 
            ex.getMessage() ,
            details);
        
        return ResponseEntityBuilder.build(err);
        }
}
