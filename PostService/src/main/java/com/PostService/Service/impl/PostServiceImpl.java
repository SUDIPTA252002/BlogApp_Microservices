package com.PostService.Service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PostService.Clients.CategoryServiceClient;
import com.PostService.Clients.UserServiceClient;
import com.PostService.Entities.Post;
import com.PostService.Entities.PostStatus;
import com.PostService.Exceptions.ResourceNotFoundException;
import com.PostService.Payloads.CategoryDTO;
import com.PostService.Payloads.PostDTO;
import com.PostService.Payloads.UserDTO;
import com.PostService.Repository.PostRepo;
import com.PostService.Service.PostService;

@Service
public class PostServiceImpl implements PostService
{

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private CategoryServiceClient categoryServiceClient;
    

    @Override
    public PostDTO createPost(PostDTO postDto,String userId,Integer categoryId) 
    {
        UserDTO userDto=userServiceClient.getUserByID(userId);

        if(userDto==null)
        {
            throw new ResourceNotFoundException("User", "userId", userId);
        }
        CategoryDTO catDto=categoryServiceClient.getCategoryById(categoryId);
        if(catDto==null)
        {
            throw new ResourceNotFoundException("Category", "categoryId", Integer.toString(categoryId));
        }
        Post post=this.modelMapper.map(postDto, Post.class);
        post.setUserId(userDto.getUserId());
        post.setCategoryId(catDto.getCategoryId());
        post.setStatus(PostStatus.valueOf(postDto.getStatus()));

        Post savedPost=this.postRepo.save(post);
        
        PostDTO savedPostDto=this.modelMapper.map(savedPost,PostDTO.class);
        savedPostDto.setAuthor(userDto);
        savedPostDto.setCategory(catDto);
        savedPostDto.setStatus(savedPost.getStatus().name());
        return savedPostDto;
    }

    @Override
    public PostDTO getPost(String postId) 
    {
        Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "postId", postId));
        
        PostDTO postDto=this.modelMapper.map(post,PostDTO.class);
        postDto.setAuthor(userServiceClient.getUserByID(post.getUserId()));
        postDto.setCategory(categoryServiceClient.getCategoryById(post.getCategoryId()));
        postDto.setStatus(post.getStatus().name());
        
        return postDto;
    }

    @Override
    public PostDTO uppdatePost(String postId, PostDTO postDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uppdatePost'");
    }

    @Override
    public void deletePost(String postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePost'");
    }
    
}
