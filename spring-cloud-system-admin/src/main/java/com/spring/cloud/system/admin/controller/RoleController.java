package com.spring.cloud.system.admin.controller;

import com.spring.cloud.commons.result.JSONResult;
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
    public JSONResult getRoleList() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/addRole")
    public JSONResult addRole() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/deleteRole")
    public JSONResult deleteRole() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/updateRole")
    public JSONResult updateRole() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/queryRole")
    public JSONResult queryRole() {
        return new JSONResult(0, null);
    }

}
