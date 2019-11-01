package com.spring.cloud.security.base;

import lombok.Data;

@Data
public class BaseDTO {
    /**
     * 当前页，默认第1页
     */
    private Integer current = 1;

    /**
     * 每页显示条数，默认10条
     */
    private Integer size = 10;

    private String field;

    private String sort;
}
