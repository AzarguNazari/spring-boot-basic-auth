package com.springboot.exercise.dtos;

import com.springboot.exercise.utils.validators.emailValidator.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull
    @NotEmpty
    private String firstName;
     
    @NotNull
    @NotEmpty
    private String lastName;
     
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
     
    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
     
    // standard getters and setters
}