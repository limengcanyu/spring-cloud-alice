package com.spring.cloud.account.microservice.service.impl;

import com.spring.cloud.account.microservice.dao.entity.AccountTbl;
import com.spring.cloud.account.microservice.dao.mapper.AccountTblMapper;
import com.spring.cloud.account.microservice.service.IAccountTblService;
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
public class AccountTblServiceImpl extends ServiceImpl<AccountTblMapper, AccountTbl> implements IAccountTblService {

}
