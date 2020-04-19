package com.spring.cloud.security.service;

import com.spring.cloud.commons.result.Result;
import com.spring.cloud.security.mybatisplus.entity.PlatformUser;

public interface AuthenticateService {
    Result register(PlatformUser registerUser);

    Result login(PlatformUser loginUser);

    Result logout(String loginUserId);
}
