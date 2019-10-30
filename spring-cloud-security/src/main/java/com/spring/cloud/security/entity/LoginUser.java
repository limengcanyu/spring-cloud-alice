package com.spring.cloud.security.entity;

import lombok.Data;

@Data
public class LoginUser {
    private String tenantId;
    private String userId;
    private String password;
    private Integer userType;
    private Integer userStatus;
}
