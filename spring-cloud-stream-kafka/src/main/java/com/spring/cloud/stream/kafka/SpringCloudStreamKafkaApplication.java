package com.spring.cloud.stream.kafka;


import com.spring.cloud.stream.kafka.channel.CommonChannel;
import com.spring.cloud.stream.kafka.message.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding({CommonChannel.class})
@SpringBootApplication
public class SpringCloudStreamKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamKafkaApplication.class, args);
    }

    /**
     * 监听输入Channel: input
     * 也即监听Topic：input
     *
     * @param user
     */
    @StreamListener(CommonChannel.INPUTOROUTPUT)
    public void processInput(User user) {
        System.out.println("Topic: " + CommonChannel.INPUTOROUTPUT + " received message: " + user);
    }

}
