package com.spring.cloud.security.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String userId;
    private String password;
}
