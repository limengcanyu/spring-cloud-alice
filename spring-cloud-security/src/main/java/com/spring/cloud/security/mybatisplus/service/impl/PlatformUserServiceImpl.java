package com.spring.cloud.security.mybatisplus.service.impl;

import com.spring.cloud.security.mybatisplus.entity.PlatformUser;
import com.spring.cloud.security.mybatisplus.mapper.PlatformUserMapper;
import com.spring.cloud.security.mybatisplus.service.IPlatformUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 平台用户表 服务实现类
 * </p>
 *
 * @author rock
 * @since 2019-10-31
 */
@Service
public class PlatformUserServiceImpl extends ServiceImpl<PlatformUserMapper, PlatformUser> implements IPlatformUserService {

}
