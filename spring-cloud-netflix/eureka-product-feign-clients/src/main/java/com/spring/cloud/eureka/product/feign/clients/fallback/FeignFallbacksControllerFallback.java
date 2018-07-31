package com.spring.cloud.eureka.product.feign.clients.fallback;

import com.spring.cloud.eureka.product.feign.clients.FeignFallbacksControllerClient;
import org.springframework.stereotype.Component;

/**
 * <p>Description: Feign Hystrix Fallbacks 接口实现类</p>
 * 需被应用扫描为Bean
 * @author Rock Jiang
 * @version 1.0
 * @date 2018/7/25 0025
 */
@Component
public class FeignFallbacksControllerFallback implements FeignFallbacksControllerClient {
    @Override
    public String getUserName() {
        return "熔断字符串";
    }
}
