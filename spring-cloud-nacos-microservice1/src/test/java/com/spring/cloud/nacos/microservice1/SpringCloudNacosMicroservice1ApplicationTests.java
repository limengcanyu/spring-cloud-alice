package com.spring.cloud.nacos.microservice1;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringCloudNacosMicroservice1ApplicationTests {

    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void encode() {
        // 第一个加密
        String password = "woshimima";
        System.out.println(encryptor.encrypt(password));
        // QyPbib2Y3EfdiPNxJUcwnic/g7E42+pHxUO2nmUr1cE=

        // 第二个加密
        password = "bushimima";
        System.out.println(encryptor.encrypt(password));
        // XNVYkcNNQWso6NW1AqjnJCnTbYMLZWghsmOs+Q9GWag=
    }

    @Value("${xxx-password:}")
    private String xxxPassword;

    @Test
    public void print() {
        System.out.println(xxxPassword);
    }

}
