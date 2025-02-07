package com.PostService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PostService.Payloads.PostDTO;
import com.PostService.Service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController
{
    @Autowired
    private PostService postService;

    @GetMapping("/get-post/{postId}")
    public ResponseEntity<?> getPosts(@PathVariable String postId)
    {
        PostDTO postDto=this.postService.getPost(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    @PostMapping("{userId}/{categoryId}/create-post")
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDto,
                                        @PathVariable String userId,
                                        @PathVariable Integer categoryId)
    {
        PostDTO createdPostDto=this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createdPostDto,HttpStatus.CREATED);
    }
    
}
