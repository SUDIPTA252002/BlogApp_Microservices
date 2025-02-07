package com.PostService.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException
{
    private String resourceName;
    private String filedName;
    private String fieldValue;

    public ResourceNotFoundException(String resourceName,String fieldName,String fieldValue)
    {
        super(String.format("%s not found with %s:%s",resourceName,fieldName,fieldValue));
        this.resourceName=resourceName;
        this.filedName=fieldName;
        this.fieldValue=fieldValue;
    }
}
