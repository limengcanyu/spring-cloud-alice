package com.spring.cloud.eureka.product.clients.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.eureka.product.clients.service.StoreIntegrationService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @author Rock Jiang
 * @version 1.0
 * @date 2018/7/24 0024
 */
@Service
public class StoreIntegrationServiceImpl implements StoreIntegrationService {

    /**
     * 指定方法调用失败后的回调方法
     *
     * @param parameters
     * @return
     */
    @HystrixCommand(fallbackMethod = "defaultStores")
    @Override
    public Object getStores(Map<String, Object> parameters) {
        //do stuff that might fail

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new String("返回调用方法结果");
    }

    /**
     * getStores方法失败后的回调方法
     *
     * @param parameters
     * @return
     */
    public Object defaultStores(Map<String, Object> parameters) {
        return new String("返回回调方法结果");
    }
}
