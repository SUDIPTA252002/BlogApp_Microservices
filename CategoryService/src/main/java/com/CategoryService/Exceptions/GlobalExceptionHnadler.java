package com.CategoryService.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.CategoryService.Payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHnadler 
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> ResourceNotFoundException(ResourceNotFoundException ex)
    {
        return new ResponseEntity<>(new ApiResponse(ex.getMessage(),false),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidExceptions(MethodArgumentNotValidException ex)
    {
        Map<String,String> response=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(err->response.put(((FieldError)err).getField(),err.getDefaultMessage()));
        return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
    }
    
}
