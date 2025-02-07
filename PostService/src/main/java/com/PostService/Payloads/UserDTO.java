package com.PostService.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO 
{
    private String userId;
    private String firstName;
    
    private String lastName;
    private String email;

    private String password;

    private String about;

    private String profilePicture;
    
}
