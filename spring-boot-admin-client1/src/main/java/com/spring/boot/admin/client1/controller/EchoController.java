package com.spring.boot.admin.client1.controller;

import com.spring.boot.admin.client1.service.EchoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author rock
 * time 2020/7/1 0001 11:25
 */
@Slf4j
@RestController
public class EchoController {
    @Autowired
    private EchoService echoService;

    /**
     * localhost:8792/echo
     *
     * @return
     */
    @RequestMapping("/echo")
    public String echo() {
        log.debug("====== log");

        try {
            echoService.echo();
        } catch (Exception e) {
            e.printStackTrace();

            log.debug("getStackTrace: ", e); // 在日志文件中打印异常堆栈
        }

        return "echo";
    }
}
