package com.spring.cloud.system.admin.controller;

import com.spring.cloud.commons.result.Result;
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
    public Result getMenuList() {
        return new Result(0, null);
    }

    @RequestMapping("/addMenu")
    public Result addMenu() {
        return new Result(0, null);
    }

    @RequestMapping("/deleteMenu")
    public Result deleteMenu() {
        return new Result(0, null);
    }

    @RequestMapping("/updateMenu")
    public Result updateMenu() {
        return new Result(0, null);
    }

    @RequestMapping("/queryMenu")
    public Result queryMenu() {
        return new Result(0, null);
    }

}
