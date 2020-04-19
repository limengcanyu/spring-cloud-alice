package com.spring.cloud.commons.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginDto {
    private String username;
    private String password;
}
