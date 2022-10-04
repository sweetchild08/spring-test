package com.example2.motor2.Web;

import org.springframework.http.ResponseEntity;

import com.example2.motor2.exceptions.ApiError;

public class ResponseEntityBuilder {
    public static ResponseEntity<Object> build(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}
