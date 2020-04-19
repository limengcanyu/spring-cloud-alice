package com.spring.cloud.web.commons.utils;

import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.commons.result.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>Description: HttpServletResponse Utils </p>
 *
 * @author rock.jiang
 * Date 2020/01/03 17:17
 */
public class ResponseUtils {
    /**
     * 写失败响应
     *
     * @param response
     * @param result
     * @throws IOException
     */
    public static void writeFailedResponse(HttpServletResponse response, Result result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF8");
        PrintWriter writer = response.getWriter();
        writer.write(JSONObject.toJSONString(result));
        writer.close();
    }
}
