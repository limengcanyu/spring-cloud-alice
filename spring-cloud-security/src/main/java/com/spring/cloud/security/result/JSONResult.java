package com.spring.cloud.security.result;

import lombok.Data;

@Data
public class JSONResult {
    public static JSONResult SUCCESS = new JSONResult(0, null);

    /**
     * 返回状态码：0-成功；非0-失败
     */
    private Integer code;

    /**
     * 成功时无须设置，失败时返回错误消息
     */
    private String message;

    private Object data;

    public JSONResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public JSONResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
