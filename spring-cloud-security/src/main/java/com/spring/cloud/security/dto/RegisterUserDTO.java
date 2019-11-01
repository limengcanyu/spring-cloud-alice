package com.spring.cloud.security.dto;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String userId;
    private String password;
}
