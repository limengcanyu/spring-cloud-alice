package com.spring.cloud.account.microservice.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.account.microservice.dao.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/06 09:14
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
