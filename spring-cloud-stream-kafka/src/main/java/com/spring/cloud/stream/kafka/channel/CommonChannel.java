package com.spring.cloud.stream.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * <p>Description: 公共Channel，接收输入，也输出</p>
 *
 * @author rock
 * date 2019/06/29
 */
public interface CommonChannel {
    String INPUTOROUTPUT = "topic";

    /**
     * 接收topic：topic的消息
     *
     * @return
     */
    @Input(CommonChannel.INPUTOROUTPUT)
    SubscribableChannel inputOrOutput();
}
