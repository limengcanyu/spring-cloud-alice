package com.spring.cloud.order.microservice.service;

import com.spring.cloud.order.microservice.dao.entity.Order;
import com.spring.cloud.order.microservice.dao.mapper.OrderMapper;
import com.spring.cloud.order.microservice.feign.AccountClient;
import com.spring.cloud.order.microservice.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/04 21:59
 */
@Service
public class OrderService {

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private OrderMapper orderMapper;

    public void create(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderMapper.insert(order);

        accountClient.debit(userId, orderMoney);

    }
}
