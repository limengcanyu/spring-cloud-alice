package com.spring.cloud.security.utils;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringEncryptorTest {
    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void encrypt() {
        String registerPassword = ".G123456789,321";
        String encodedPassword = stringEncryptor.encrypt(registerPassword);
        System.out.println(encodedPassword);
    }

    @Test
    public void decrypt() {
        String encodedPassword = "MjGoxRASljZg8ksuzEV2JZoT4DqeeQbw";
        String registerPassword = stringEncryptor.decrypt(encodedPassword);
        System.out.println(registerPassword);
    }
}
