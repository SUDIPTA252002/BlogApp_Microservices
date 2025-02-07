package com.PostService.Payloads;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO 
{
    private String postId;
    private String title;
    private String slug;
    private String excerpt;
    private String content;
    private String status;
   // private List<String> tags;
    private Instant publishedAt;
    private Instant updatedAt;
    private String featuredImageUrl;

    private UserDTO author;
    private CategoryDTO category;

    // private Object blogSeo; // Placeholder for future implementation
    // private Object blogEngagement; 
    
}
