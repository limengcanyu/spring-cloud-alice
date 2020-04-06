package com.spring.cloud.account.microservice.service;

import com.spring.cloud.account.microservice.dao.entity.Account;
import com.spring.cloud.account.microservice.dao.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/04 21:37
 */
@Service
public class AccountService {

    private static final String ERROR_USER_ID = "1002";

    @Autowired
    private AccountMapper accountMapper;

    public void debit(String userId, BigDecimal num) {
        Account account = accountMapper.selectByUserId(userId);
        account.setMoney(account.getMoney().subtract(num));
        accountMapper.updateById(account);

        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }
}
