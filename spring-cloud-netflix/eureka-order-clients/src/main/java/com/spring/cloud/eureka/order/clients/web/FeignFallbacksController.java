package com.spring.cloud.eureka.order.clients.web;

import com.spring.cloud.eureka.product.feign.clients.FeignFallbacksControllerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 *
 * @author Rock Jiang
 * @version 1.0
 * @date 2018/7/31 0031
 */
@RestController
public class FeignFallbacksController {
    @Autowired
    private FeignFallbacksControllerClient feignFallbacksControllerClient;

    /**
     * Feign Hystrix Fallbacks
     * Feign熔断回调测试
     *
     * @return
     */
    @RequestMapping("/order/getUserName")
    public String getUserName() {
        return feignFallbacksControllerClient.getUserName();
    }
}
