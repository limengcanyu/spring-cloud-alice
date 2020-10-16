package com.spring.cloud.stream.rabbitmq.consumer.config;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * description: Annotation-based support (legacy)
 *
 * attach the output channel of a Source to a MessageSource and use the familiar @InboundChannelAdapter annotation
 *
 * @author rock
 * time 2020/7/16 0016 14:30
 */
//@EnableBinding(Source.class)
public class TimerSource {
    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10", maxMessagesPerPoll = "1"))
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage<>("Hello Spring Cloud Stream");
    }
}
