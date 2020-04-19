package com.spring.cloud.system.admin.controller;

import com.spring.cloud.commons.result.Result;
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
    public Result getUserList() {
        return new Result(0, null);
    }

    @RequestMapping("/addUser")
    public Result addUser() {
        return new Result(0, null);
    }

    @RequestMapping("/deleteUser")
    public Result deleteUser() {
        return new Result(0, null);
    }

    @RequestMapping("/updateUser")
    public Result updateUser() {
        return new Result(0, null);
    }

    @RequestMapping("/queryUser")
    public Result queryUser() {
        return new Result(0, null);
    }

}
