package com.UserService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserService.Entities.User;


@Repository
public interface UserRepo extends JpaRepository<User,String>
{
    Optional<User> findByEmail(String email);
    boolean existByEmail(String email);
    
} 