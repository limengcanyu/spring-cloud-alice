package com.spring.cloud.order.microservice.service;

import com.spring.cloud.order.microservice.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/04 21:59
 */
@Service
public class OrderService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(String userId, String commodityCode, Integer count) {

        int orderMoney = count * 100;
        jdbcTemplate.update("insert order_tbl(user_id,commodity_code,count,money) values(?,?,?,?)",
                new Object[] {userId, commodityCode, count, orderMoney});

        userFeignClient.reduce(userId, orderMoney);

    }
}
