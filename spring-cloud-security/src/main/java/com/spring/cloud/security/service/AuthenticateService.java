package com.spring.cloud.security.service;

import com.spring.cloud.commons.dto.LoginDto;
import com.spring.cloud.commons.dto.RegisterDto;
import com.spring.cloud.commons.result.Result;

public interface AuthenticateService {
    Result register(RegisterDto registerDto);

    Result login(LoginDto loginDto);

    Result logout(String loginUserId);
}
