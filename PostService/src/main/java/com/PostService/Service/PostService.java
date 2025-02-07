package com.PostService.Service;

import com.PostService.Payloads.PostDTO;

public interface PostService 
{

    PostDTO createPost(PostDTO postDto,String userId,Integer categoryId);
    PostDTO getPost(String postId);
    PostDTO uppdatePost(String postId,PostDTO postDto);
    void deletePost(String postId);
    
    
}
