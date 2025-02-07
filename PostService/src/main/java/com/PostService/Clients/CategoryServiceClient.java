package com.PostService.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PostService.Clients.Fallbacks.CategoryServiceFallback;
import com.PostService.Payloads.CategoryDTO;

@FeignClient(name="CategoryService",fallback = CategoryServiceFallback.class)
public interface CategoryServiceClient 
{
    @GetMapping("/api/category/get-category/{catId}")
    CategoryDTO getCategoryById(@PathVariable Integer catId);
    
}
