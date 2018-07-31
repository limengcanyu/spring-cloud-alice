package com.spring.cloud.eureka.product.clients.web;

import com.spring.cloud.eureka.product.clients.service.StoreIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>Description: Circuit Breaker: Hystrix Clients</p>
 *
 * @author Rock Jiang
 * @version 1.0
 * @date 2018/7/30 0030
 */
@RestController
public class HystrixClientsController {
    @Autowired
    private StoreIntegrationService storeIntegrationService;

    /**
     * 断路器客户端测试，此方法调用Service中的方法，若Service中的方法失败，则调用指定的回调方法返回友好结果
     *
     * @param parameters
     * @return
     */
    @RequestMapping("/hystrixClient/getStores")
    public String getStores(Map<String, Object> parameters) {
        return (String) storeIntegrationService.getStores(null);
    }
}
