package com.spring.cloud.microservice1.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2019/12/25 10:57
 */
@Api("hello app")
@Slf4j
@RestController
public class EchoController {

    @ApiOperation(value = "获取用户列表", notes = "获取所有用户信息")
    @GetMapping("/")
    public String home() {
        return "Hello MicroService1";
    }

    @RequestMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        log.info("MicroService1 Hello " + string);
        return "MicroService1 Hello " + string;
    }

    @RequestMapping("/modifyRequestBody")
    public String modifyRequestBody(@RequestBody Map<String, Object> param) {
        log.info("MicroService1 modifyRequestBody param " + param);
        return "MicroService1 modifyRequestBody " + param;
    }

    @RequestMapping("/save")
    public String save(@RequestBody JSONObject routeJsonObject) {
        return "MicroService1 Hello " + JSONObject.toJSONString(routeJsonObject);
    }

}
