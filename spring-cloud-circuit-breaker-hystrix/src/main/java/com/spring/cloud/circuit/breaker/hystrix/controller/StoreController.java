package com.spring.cloud.circuit.breaker.hystrix.controller;

import com.spring.cloud.circuit.breaker.hystrix.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: Store Controller </p>
 *
 * @author rock.jiang
 * Date 2020/04/19 19:43
 */
@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;

    /**
     * localhost:8200/getStores
     *
     * @return
     */
    @RequestMapping("/getStores")
    public Object getStores() {
        try {
            return storeService.getStores(null);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
