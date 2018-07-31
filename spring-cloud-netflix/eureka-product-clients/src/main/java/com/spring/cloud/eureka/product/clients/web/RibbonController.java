package com.spring.cloud.eureka.product.clients.web;

import com.spring.cloud.eureka.product.clients.dto.ProductInfoDTO;
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
public class RibbonController {
    /**
     * 测试Ribbon负载均衡，起3个服务，每次调用会切换不同的服务
     *
     * @return
     */
    @RequestMapping("/ribbon/getProductInfo")
    public ProductInfoDTO getProductInfo(){
        System.out.println("测试Ribbon负载均衡");

        ProductInfoDTO productInfoDTO = new ProductInfoDTO();
        productInfoDTO.setRecordId(1L);
        productInfoDTO.setProductId("P00001");
        productInfoDTO.setProductName("产品1");

        return productInfoDTO;
    }
}
