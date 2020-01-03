package com.spring.cloud.common.dto;

import lombok.Data;

@Data
public class LoginUserDto {
    private String userId;
    private String password;
}
