package com.spring.cloud.security.dto;

import lombok.Data;

@Data
public class LoginUserDTO {
    private String userId;
    private String password;
}
