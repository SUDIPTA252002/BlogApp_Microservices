package com.PostService.Clients.Fallbacks;

import org.springframework.stereotype.Component;

import com.PostService.Clients.CategoryServiceClient;
import com.PostService.Exceptions.ServiceUnavailable;
import com.PostService.Payloads.CategoryDTO;


@Component
public class CategoryServiceFallback implements CategoryServiceClient
{

    @Override
    public CategoryDTO getCategoryById(Integer catId) 
    {
        throw new ServiceUnavailable("Category");
    }
    
}
