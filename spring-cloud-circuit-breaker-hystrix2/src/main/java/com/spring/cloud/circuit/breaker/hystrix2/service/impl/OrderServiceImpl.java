package com.spring.cloud.circuit.breaker.hystrix2.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.circuit.breaker.hystrix2.feign.StoreClient;
import com.spring.cloud.circuit.breaker.hystrix2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/19 19:41
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private StoreClient storeClient;

    @HystrixCommand(fallbackMethod = "defaultOrders")
    @Override
    public String getOrders(Map<String, Object> parameters) throws Exception {
        //do stuff that might fail
//        return "normal return";
        throw new RuntimeException(); // 出现异常调用 fallbackMethod 返回
    }

    public String defaultOrders(Map<String, Object> parameters) {
        return "fallback return";
    }

    @Override
    public String getStores() {
        return storeClient.getStores();
    }
}
