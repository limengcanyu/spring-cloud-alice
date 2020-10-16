package com.spring.cloud.stream.rabbitmq.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@RestController
public class SupplierController {
    @Autowired
    private Supplier<String> stringSupplier;

    @Autowired
    private Consumer<String> stringConsumer;

    @Autowired
    private Function<String, String> uppercase;

    /**
     * localhost:8080/stringSupplier
     *
     * @return
     */
    @RequestMapping("/stringSupplier")
    public String stringSupplier() {
        return stringSupplier.get().toString();
    }

    /**
     * localhost:8080/stringConsumer
     *
     * @return
     */
    @RequestMapping("/stringConsumer")
    public String stringConsumer() {
        stringConsumer.accept("string Consumer");
        return "dateConsumer";
    }

    /**
     * localhost:8080/date
     *
     * @return
     */
    @RequestMapping("/uppercase")
    public String uppercase() {
        // 将参数发送到消息队列，再经过转换为大写返回给前台
        return uppercase.apply("sdfsdfsdf");
    }
}
