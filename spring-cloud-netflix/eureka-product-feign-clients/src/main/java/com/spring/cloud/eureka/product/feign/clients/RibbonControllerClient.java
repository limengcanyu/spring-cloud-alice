package com.spring.cloud.eureka.product.feign.clients;

import com.spring.cloud.eureka.product.feign.clients.dto.ProductInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Description: </p>
 *
 * @author Rock Jiang
 * @version 1.0
 * @date 2018/7/31 0031
 */
@FeignClient(name = "eureka-product-clients")
public interface RibbonControllerClient {
    @RequestMapping("/ribbon/getProductInfo")
    ProductInfoDTO getProductInfo();
}
