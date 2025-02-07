package com.PostService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.PostService.Entities.Post;

@Repository
public interface PostRepo extends MongoRepository<Post,String>
{

    
}
