package com.spring.cloud.system.admin.controller;

import com.spring.cloud.commons.result.JSONResult;
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
    public JSONResult getOrgList() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/addOrg")
    public JSONResult addOrg() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/deleteOrg")
    public JSONResult deleteOrg() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/updateOrg")
    public JSONResult updateOrg() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/queryOrg")
    public JSONResult queryOrg() {
        return new JSONResult(0, null);
    }

}
