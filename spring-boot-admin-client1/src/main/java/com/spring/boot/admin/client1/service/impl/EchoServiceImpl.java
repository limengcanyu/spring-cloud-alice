package com.spring.boot.admin.client1.service.impl;

import com.spring.boot.admin.client1.service.EchoService;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author rock
 * time 2020/7/1 0001 11:24
 */
@Service
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo() throws Exception {
        throw new Exception("抛出异常");
    }
}
