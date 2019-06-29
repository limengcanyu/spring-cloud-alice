package com.spring.cloud.stream.kafka;

import com.spring.cloud.stream.kafka.channel.CommonChannel;
import com.spring.cloud.stream.kafka.message.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext
public class SpringCloudStreamKafkaApplicationTest {
    @Autowired
    private CommonChannel commonChannel;

    @Test
    public void contextLoads() {
        Message<User> message = new GenericMessage<>(new User("userId", "userName"));
        // 向输入Channel（input）发送消息，也即想Topic（input）发送消息
        commonChannel.inputOrOutput().send(message);
    }
}
