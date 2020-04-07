package com.spring.cloud.storage.microservice.service.impl;

import com.spring.cloud.storage.microservice.dao.entity.StorageTbl;
import com.spring.cloud.storage.microservice.dao.mapper.StorageTblMapper;
import com.spring.cloud.storage.microservice.service.IStorageTblService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rock
 * @since 2020-04-07
 */
@Service
public class StorageTblServiceImpl extends ServiceImpl<StorageTblMapper, StorageTbl> implements IStorageTblService {

}
