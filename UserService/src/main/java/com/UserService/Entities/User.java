package com.UserService.Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Users")
@NoArgsConstructor
@Getter
@Setter
public class User 
{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String  userId;
    
    @Column(name="firstName",nullable = false,length = 100)
    private String firstName;

    @Column(name="lastName",nullable = false,length = 100)
    private String lastName;
    
    
    @Column(name="email",nullable = false,length = 100)
    private String email;

    @Column(name="password",nullable=false,length = 100)
    private String password;

    @Column(name="about",nullable = true,length = 200)
    private String about;

    @Column(name="Porfile Picture",nullable=true)
    private String profilePicture;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // @OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    // List<Post> posts=new ArrayList<>();

    // @OneToMany(mappedBy = "user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    // List<Likes> likes=new ArrayList<>();

    @PrePersist
    protected void onCreate() 
    {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() 
    {
        updatedAt = LocalDateTime.now();
    }

}
