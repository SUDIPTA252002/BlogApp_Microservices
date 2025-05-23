package com.UserService.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuplicateResourceException extends RuntimeException
{
    private String message;

    public DuplicateResourceException(String message)
    {
        super(String.format("%s already exists",message));
        this.message=message;
    }
    
}
