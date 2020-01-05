package com.spring.cloud.system.admin.controller;

import com.spring.cloud.commons.result.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: User Controller </p>
 *
 * @author rock.jiang
 * Date 2020/01/04 23:57
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @RequestMapping("/getUserList")
    public JSONResult getUserList() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/addUser")
    public JSONResult addUser() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/deleteUser")
    public JSONResult deleteUser() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/updateUser")
    public JSONResult updateUser() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/queryUser")
    public JSONResult queryUser() {
        return new JSONResult(0, null);
    }

}
