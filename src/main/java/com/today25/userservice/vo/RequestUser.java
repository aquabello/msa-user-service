package com.today25.userservice.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestUser {

    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less then two characters")
    private String email;

    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less then two characters")
    private String name;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be equals or grater then 8 characters")
    private String pwd;

}
