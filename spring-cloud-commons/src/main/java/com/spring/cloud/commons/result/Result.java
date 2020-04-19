package com.spring.cloud.commons.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Description: Result </p>
 *
 * @author rock.jiang
 * Date 2020/01/03 15:15
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
}
