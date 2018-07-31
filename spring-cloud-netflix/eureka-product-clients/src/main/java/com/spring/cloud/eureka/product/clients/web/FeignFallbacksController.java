package com.spring.cloud.eureka.product.clients.web;

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
    /**
     * Feign Hystrix Fallbacks
     * Feign熔断回调测试
     *
     * @return
     */
    @RequestMapping("/product/getUserName")
    public String getUserName() {
        //50秒后返回结果
//        try {
//            Thread.sleep(50000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "古陵逝烟";
    }
}
