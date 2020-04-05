package com.spring.cloud.account.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/04 21:37
 */
@Service
public class AccountService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void reduce(String userId, int money) {
        jdbcTemplate.update("update account_tbl set money = money - ? where user_id = ?", new Object[] {money, userId});
    }
}
