package com.spring.cloud.system.admin.controller;

import com.spring.cloud.commons.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: Template Controller </p>
 *
 * @author rock.jiang
 * Date 2020/01/04 23:57
 */
@RequestMapping("/template")
@RestController
public class TemplateController {

    @RequestMapping("/getTemplateList")
    public Result getTemplateList() {
        return new Result(0, null);
    }

    @RequestMapping("/addTemplate")
    public Result addTemplate() {
        return new Result(0, null);
    }

    @RequestMapping("/deleteTemplate")
    public Result deleteTemplate() {
        return new Result(0, null);
    }

    @RequestMapping("/updateTemplate")
    public Result updateTemplate() {
        return new Result(0, null);
    }

    @RequestMapping("/queryTemplate")
    public Result queryTemplate() {
        return new Result(0, null);
    }

}
