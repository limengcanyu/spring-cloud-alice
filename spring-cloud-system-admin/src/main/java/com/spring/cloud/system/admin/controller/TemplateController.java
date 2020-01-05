package com.spring.cloud.system.admin.controller;

import com.spring.cloud.commons.result.JSONResult;
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
    public JSONResult getTemplateList() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/addTemplate")
    public JSONResult addTemplate() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/deleteTemplate")
    public JSONResult deleteTemplate() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/updateTemplate")
    public JSONResult updateTemplate() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/queryTemplate")
    public JSONResult queryTemplate() {
        return new JSONResult(0, null);
    }

}
