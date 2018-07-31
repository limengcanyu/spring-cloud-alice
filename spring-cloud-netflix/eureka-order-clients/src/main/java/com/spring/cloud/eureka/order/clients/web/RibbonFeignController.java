package com.spring.cloud.eureka.order.clients.web;

import com.spring.cloud.eureka.product.feign.clients.RibbonControllerClient;
import com.spring.cloud.eureka.product.feign.clients.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: Client Side Load Balancer: Ribbon</p>
 *
 * @author Rock Jiang
 * @version 1.0
 * @date 2018/7/31 0031
 */
@RestController
public class RibbonFeignController {
    @Autowired
    private RibbonControllerClient ribbonControllerClient;

    /**
     * 测试Ribbon负载均衡，服务提供者起3个服务，每次调用会调用到不同的服务
     *
     * @return
     */
    @RequestMapping("/order/getProductInfo")
    public ProductInfoDTO getProductInfo(){
        return ribbonControllerClient.getProductInfo();
    }
}
