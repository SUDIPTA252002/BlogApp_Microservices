package com.PostService.Entities;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="posts")
public class Post 
{
    @Id
    private String postId;

     private String title;
    private String slug;
    private String excerpt;
    private String content;

    private PostStatus status;

    //private List<String> tags;
    private String featuredImageUrl;


    @CreatedDate
    private Instant publishedAt;
    @LastModifiedDate
    private Instant updatedAt;

    private String userId; 
    private Integer categoryId; 


    // private Object blogSeo;  
    // private Object blogEngagement;

}
