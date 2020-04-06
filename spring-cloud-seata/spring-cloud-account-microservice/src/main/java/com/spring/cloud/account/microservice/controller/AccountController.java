package com.spring.cloud.account.microservice.controller;

import com.spring.cloud.account.microservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * @date 2020/04/04 21:35
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/reduce", produces = "application/json")
    public Boolean debit(String userId, int money) {
        accountService.debit(userId, money);
        return true;
    }
}
