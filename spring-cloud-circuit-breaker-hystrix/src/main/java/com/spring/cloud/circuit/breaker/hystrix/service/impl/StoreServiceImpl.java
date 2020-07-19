package com.spring.cloud.circuit.breaker.hystrix.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.circuit.breaker.hystrix.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/19 19:41
 */
@Service
public class StoreServiceImpl implements StoreService {

    @HystrixCommand(fallbackMethod = "defaultStores" )
    @Override
    public Object getStores(Map<String, Object> parameters) throws Exception {
        //do stuff that might fail
        // 正常返回
//        return "normal return";

        // 出现异常调用 fallbackMethod 返回
//        throw new RuntimeException();

        // 调用超时
        Thread.sleep(5000);
        return "normal return";
    }

    public Object defaultStores(Map<String, Object> parameters) {
        return "fallback return";
    }
}
