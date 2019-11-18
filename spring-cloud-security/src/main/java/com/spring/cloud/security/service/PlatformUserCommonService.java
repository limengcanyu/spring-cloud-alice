package com.spring.cloud.security.service;

import com.spring.cloud.security.mybatisplus.entity.PlatformUser;

public interface PlatformUserCommonService {
    PlatformUser getPlatformUser(String userId);
}
