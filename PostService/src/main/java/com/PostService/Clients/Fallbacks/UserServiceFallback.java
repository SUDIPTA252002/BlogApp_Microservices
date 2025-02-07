package com.PostService.Clients.Fallbacks;


import org.springframework.stereotype.Component;

import com.PostService.Clients.UserServiceClient;
import com.PostService.Exceptions.ServiceUnavailable;
import com.PostService.Payloads.UserDTO;

@Component
public class UserServiceFallback implements UserServiceClient
{

    @Override
    public UserDTO getUserByID(String userId) 
    {
        throw new ServiceUnavailable("User");
    }

    
}
