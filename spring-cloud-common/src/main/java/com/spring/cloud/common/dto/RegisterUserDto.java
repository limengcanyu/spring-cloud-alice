package com.spring.cloud.common.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String userId;
    private String password;
}
