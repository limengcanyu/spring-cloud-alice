package com.spring.cloud.stream.rabbitmq.consumer.config;

import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

/**
 * description: Annotation-based support (legacy)
 *
 * use @Transformer or @ServiceActivator while providing an implementation of a message handler method for a Processor binding contract
 *
 * @author rock
 * time 2020/7/16 0016 14:31
 */
//@EnableBinding(Processor.class)
public class TransformProcessor {
    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object transform(String message) {
        return message.toUpperCase();
    }
}
