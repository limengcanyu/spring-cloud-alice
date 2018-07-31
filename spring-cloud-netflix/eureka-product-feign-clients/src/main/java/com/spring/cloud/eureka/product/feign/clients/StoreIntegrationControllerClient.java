package com.spring.cloud.eureka.product.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Description: </p>
 *
 * @author Rock Jiang
 * @version 1.0
 * @date 2018/7/24 0024
 */
@FeignClient("eureka-product-clients")
public interface StoreIntegrationControllerClient {
    @RequestMapping("/getTime")
    String getTime();
}
