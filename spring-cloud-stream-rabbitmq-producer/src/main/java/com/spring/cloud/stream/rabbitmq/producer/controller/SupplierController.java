package com.spring.cloud.stream.rabbitmq.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@RestController
public class SupplierController {
//    @Autowired
//    private Supplier<String> stringSupplier;

    @Autowired
    private Supplier<Flux<String>> stringSupplier;

    @Autowired
    private Consumer<String> stringConsumer;

    @Autowired
    private Function<String, String> uppercase;

    @Autowired
    private Function<String, String> inputCase;

//    /**
//     * localhost:8080/stringSupplier
//     *
//     * @return
//     */
//    @RequestMapping("/stringSupplier")
//    public String stringSupplier() {
//        return stringSupplier.get();
//    }

    /**
     * localhost:8080/stringSupplier
     *
     * @return
     */
    @RequestMapping("/stringSupplier")
    public String stringSupplier() {
        stringSupplier.get();
        return "success";
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
     * localhost:8080/helloCase
     *
     * @return
     */
    @RequestMapping("/inputCase")
    public String inputCase() {
        // 将参数发送到消息队列，再经过转换为大写返回给前台
        return inputCase.apply("sdfsdfsdf");
    }

    /**
     * localhost:8080/uppercase
     *
     * @return
     */
    @RequestMapping("/uppercase")
    public String uppercase() {
        // 将参数发送到消息队列，再经过转换为大写返回给前台
        return uppercase.apply("sdfsdfsdf");
    }
}
