package com.spring.cloud.microservice1.mybatisPlus.service.impl;

import com.spring.cloud.microservice1.mybatisPlus.entity.PlatformUser;
import com.spring.cloud.microservice1.mybatisPlus.mapper.PlatformUserMapper;
import com.spring.cloud.microservice1.mybatisPlus.service.IPlatformUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 平台用户表 服务实现类
 * </p>
 *
 * @author rock
 * @since 2020-04-20
 */
@Service
public class PlatformUserServiceImpl extends ServiceImpl<PlatformUserMapper, PlatformUser> implements IPlatformUserService {

}
