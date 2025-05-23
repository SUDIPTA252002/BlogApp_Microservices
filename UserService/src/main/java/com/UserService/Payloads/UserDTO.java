package com.UserService.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message="FIRST NAME SHOULD NOT BE BLANK")
    private String firstName;
    
    @NotBlank(message="LAST NAME SHOULD NOT BE BLANK")
    private String lastName;

    @Email(message ="EMAIL IS INVALID")
    @NotBlank(message = "EMAIL IS REQUIRED")
    private String email;

    @NotEmpty
    @Pattern(regexp =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
             message = "Password must contain at least 8 characters, one uppercase, one lowercase, one number and one special character")
    private String password;

    private String about;

    private String profilePicture;
    
}
