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
     * 返回信息：成功时为空，错误时才有信息
     */
    private String message;

    private String token;

    /**
     * 返回数据
     */
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

    public JSONResult(Integer code, String message, String token) {
        this.code = code;
        this.message = message;
        this.token = token;
    }

    public JSONResult(Integer code, String message, String token, Object data) {
        this.code = code;
        this.message = message;
        this.token = token;
        this.data = data;
    }
}
