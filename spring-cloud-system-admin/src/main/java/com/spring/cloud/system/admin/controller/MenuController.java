package com.spring.cloud.system.admin.controller;

import com.spring.cloud.commons.result.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: Menu Controller </p>
 *
 * @author rock.jiang
 * Date 2020/01/04 23:57
 */
@RequestMapping("/menu")
@RestController
public class MenuController {

    @RequestMapping("/getMenuList")
    public JSONResult getMenuList() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/addMenu")
    public JSONResult addMenu() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/deleteMenu")
    public JSONResult deleteMenu() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/updateMenu")
    public JSONResult updateMenu() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/queryMenu")
    public JSONResult queryMenu() {
        return new JSONResult(0, null);
    }

}
