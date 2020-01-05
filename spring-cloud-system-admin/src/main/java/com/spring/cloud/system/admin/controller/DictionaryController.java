package com.spring.cloud.system.admin.controller;

import com.spring.cloud.commons.result.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: Dictionary Controller </p>
 *
 * @author rock.jiang
 * Date 2020/01/04 23:57
 */
@RequestMapping("/dic")
@RestController
public class DictionaryController {

    @RequestMapping("/getDictionaryList")
    public JSONResult getDictionaryList() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/addDictionary")
    public JSONResult addDictionary() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/deleteDictionary")
    public JSONResult deleteDictionary() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/updateDictionary")
    public JSONResult updateDictionary() {
        return new JSONResult(0, null);
    }

    @RequestMapping("/queryDictionary")
    public JSONResult queryDictionary() {
        return new JSONResult(0, null);
    }

}
