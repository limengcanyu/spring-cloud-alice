package com.spring.cloud.web.commons.utils;

import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>Description: HttpServletRequest Utils </p>
 *
 * @author rock.jiang
 * Date 2020/01/03 18:08
 */
public class RequestUtils {
    public static SortedMap<String, Object> getRequestParams(HttpServletRequest request) {
        SortedMap<String, Object> paramMap = new TreeMap<>();

        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
        if (!CollectionUtils.isEmpty(entrySet)) {
            for (Map.Entry<String, String[]> entry : entrySet) {
                String parameterName = entry.getKey();
                String[] parameterValues = entry.getValue();
                paramMap.put(parameterName, Arrays.asList(parameterValues));
            }
        }

        return paramMap;
    }
}
