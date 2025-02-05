package com.PostService.Service;

import java.util.List;

import com.PostService.Entities.Post;
import com.PostService.Payloads.PostDTO;


public interface PostService
{
    PostDTO createPost(PostDTO postDto,Integer categoryId,String userId);

    PostDTO getPost(Integer postId);

    List<PostDTO> getAll();

    PostDTO updatePost(PostDTO postDto,Integer postId);

    void deletePost(Integer postId);

    // List<PostDTO> getPostByUser(String userId);

    // List<PostDTO> getPostByCategory(Integer categoryId);

    // List<Post> searchPost(String keyword);
    
}
