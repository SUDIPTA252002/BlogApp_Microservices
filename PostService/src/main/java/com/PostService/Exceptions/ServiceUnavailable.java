package com.PostService.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceUnavailable extends RuntimeException 
{
    private String serviceName;

    public ServiceUnavailable(String serviceName)
    {
        super(String.format("%s Service is not available at the moment",serviceName));
        this.serviceName=serviceName;
    }
    
}
