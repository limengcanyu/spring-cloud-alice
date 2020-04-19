package com.spring.cloud.system.admin.controller;

import com.spring.cloud.commons.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/01/05 00:00
 */
@RequestMapping("/org")
@RestController
public class OrganizationController {
    @RequestMapping("/getOrgList")
    public Result getOrgList() {
        return new Result(0, null);
    }

    @RequestMapping("/addOrg")
    public Result addOrg() {
        return new Result(0, null);
    }

    @RequestMapping("/deleteOrg")
    public Result deleteOrg() {
        return new Result(0, null);
    }

    @RequestMapping("/updateOrg")
    public Result updateOrg() {
        return new Result(0, null);
    }

    @RequestMapping("/queryOrg")
    public Result queryOrg() {
        return new Result(0, null);
    }

}
