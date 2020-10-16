package com.spring.cloud.stream.rabbitmq.producer.controller;

import com.spring.cloud.stream.rabbitmq.producer.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
public class SupplierController {
    @Autowired
    private Supplier<Person> personSupplier;

    /**
     * 发送消息到Queue
     *
     * localhost:8900/supplyPerson
     *
     * @return
     */
    @RequestMapping("/supplyPerson")
    public String supplyPerson() {
        personSupplier.get();
        return "supply person success";
    }
}
