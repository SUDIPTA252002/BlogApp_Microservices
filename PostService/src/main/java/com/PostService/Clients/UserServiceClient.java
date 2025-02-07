package com.PostService.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PostService.Clients.Fallbacks.UserServiceFallback;
import com.PostService.Payloads.UserDTO;

@FeignClient(name="UserService",fallback = UserServiceFallback.class)
public interface UserServiceClient 
{
    @GetMapping("/api/users/get-user/{userId}")
    UserDTO getUserByID(@PathVariable String userId);
    

    
}
