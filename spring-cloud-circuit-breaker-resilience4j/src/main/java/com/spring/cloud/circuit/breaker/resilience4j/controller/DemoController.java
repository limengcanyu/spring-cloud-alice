package com.spring.cloud.circuit.breaker.resilience4j.controller;

import com.spring.cloud.circuit.breaker.resilience4j.service.HttpBinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @author rock.jxf
 * @date 2020/5/23 20:31
 */
@Slf4j
@RestController
public class DemoController {
    private CircuitBreakerFactory circuitBreakerFactory;
    private HttpBinService httpBin;

    public DemoController(CircuitBreakerFactory circuitBreakerFactory, HttpBinService httpBinService) {
        this.circuitBreakerFactory = circuitBreakerFactory;
        this.httpBin = httpBinService;
    }

    /**
     * localhost:8800/get
     *
     * @return
     */
    @GetMapping("/get")
    public Map get() {
        return httpBin.get();
    }

    /**
     * localhost:8800/delay/5
     *
     * 超时产生断路
     *
     * @param seconds
     * @return
     */
    @GetMapping("/delay/{seconds}")
    public Map delay(@PathVariable int seconds) {
        return circuitBreakerFactory.create("delay").run(httpBin.delaySuppplier(seconds), t -> {
            log.warn("delay call failed error", t);
            Map<String, String> fallback = new HashMap<>();
            fallback.put("hello", "world");
            return fallback; // 返回断路回调结果
        });
    }
}
