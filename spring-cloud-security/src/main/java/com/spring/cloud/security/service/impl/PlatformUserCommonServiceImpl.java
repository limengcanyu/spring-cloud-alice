package com.spring.cloud.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.spring.cloud.security.mybatisplus.entity.PlatformUser;
import com.spring.cloud.security.mybatisplus.service.IPlatformUserService;
import com.spring.cloud.security.service.PlatformUserCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformUserCommonServiceImpl implements PlatformUserCommonService {
    @Autowired
    private IPlatformUserService platformUserService;

    @Override
    public PlatformUser getPlatformUser(String userId) {
        LambdaQueryWrapper<PlatformUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PlatformUser::getUserId, userId);
        return platformUserService.getOne(queryWrapper);
    }
}
