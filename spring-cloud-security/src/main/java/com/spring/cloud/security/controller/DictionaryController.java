package com.spring.cloud.security.controller;

import com.spring.cloud.commons.result.Result;
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
    public Result getDictionaryList() {
        return new Result(0, null);
    }

    @RequestMapping("/addDictionary")
    public Result addDictionary() {
        return new Result(0, null);
    }

    @RequestMapping("/deleteDictionary")
    public Result deleteDictionary() {
        return new Result(0, null);
    }

    @RequestMapping("/updateDictionary")
    public Result updateDictionary() {
        return new Result(0, null);
    }

    @RequestMapping("/queryDictionary")
    public Result queryDictionary() {
        return new Result(0, null);
    }

}
