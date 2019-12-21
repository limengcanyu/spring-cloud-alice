package com.spring.cloud.security.dto;

import lombok.Data;

@Data
public class LoginUserDto {
    private String userId;
    private String password;
}
