package com.PostService.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.PostService.Payloads.ApiResponse;

public class GlobalExceptionHandler 
{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHnadler(ResourceNotFoundException ex)
    {
        return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(),false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServiceUnavailable.class)
    public ResponseEntity<ApiResponse> serviceUnavailableHandler(ServiceUnavailable ex)
    {
        return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(),false), HttpStatus.SERVICE_UNAVAILABLE);
    }
    
}
