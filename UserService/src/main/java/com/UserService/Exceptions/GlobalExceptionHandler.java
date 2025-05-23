package com.UserService.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.UserService.Payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
    {
        return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(),false),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse> duplicateResourceExceptionHandler(DuplicateResourceException ex)
    {
        return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(),false),HttpStatus.CONFLICT);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidExceptions(MethodArgumentNotValidException ex)
    {
        Map<String,String> response=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(err->response.put(((FieldError)err).getField(),err.getDefaultMessage()));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);        
    }
}
