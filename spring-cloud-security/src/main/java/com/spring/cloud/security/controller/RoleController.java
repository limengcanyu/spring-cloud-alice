package com.spring.cloud.security.controller;

import com.spring.cloud.commons.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: Role Controller </p>
 *
 * @author rock.jiang
 * Date 2020/01/04 23:57
 */
@RequestMapping("/role")
@RestController
public class RoleController {

    @RequestMapping("/getRoleList")
    public Result getRoleList() {
        return new Result(0, null);
    }

    @RequestMapping("/addRole")
    public Result addRole() {
        return new Result(0, null);
    }

    @RequestMapping("/deleteRole")
    public Result deleteRole() {
        return new Result(0, null);
    }

    @RequestMapping("/updateRole")
    public Result updateRole() {
        return new Result(0, null);
    }

    @RequestMapping("/queryRole")
    public Result queryRole() {
        return new Result(0, null);
    }

}
