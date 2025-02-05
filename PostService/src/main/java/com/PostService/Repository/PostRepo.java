package com.PostService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PostService.Entities.Post;

//import com.BlogApp.Entities.Category;
//import com.BlogApp.Entities.User;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer>
{
    // List<Post> findAllByUser(User user);
    // List<Post> findAllByCategory(Category category);
}
