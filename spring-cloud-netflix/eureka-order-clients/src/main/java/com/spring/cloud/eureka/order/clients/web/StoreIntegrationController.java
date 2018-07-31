package com.spring.cloud.eureka.order.clients.web;

import com.spring.cloud.eureka.product.feign.clients.StoreIntegrationControllerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>Description: </p>
 *
 * @author Rock Jiang
 * @version 1.0
 * @date 2018/7/30 0030
 */
@RestController
public class StoreIntegrationController {
    @Autowired
    private StoreIntegrationControllerClient storeIntegrationControllerClient;

    @RequestMapping("/getTimeNow")
    public String getTimeNow() {
        System.out.println("调用开始时间: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        String retStr = storeIntegrationControllerClient.getTime();
        System.out.println("调用结束时间: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return retStr;
    }

}
