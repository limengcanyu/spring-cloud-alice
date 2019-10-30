package com.spring.cloud.security.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisTemplateUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void setObject(String key, Object value) {
        stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(value));
    }

    public <T> void setList(String key, List<T> valueList) {
        stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(valueList));
    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public <T> T getObject(String key, Class<T> valueClass) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return JSONObject.parseObject(value, valueClass);
    }

    public <T> List<T> getList(String key, Class<T> valueClass) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return JSONObject.parseArray(value, valueClass);
    }

    public void increment(String key, long delta) {
        stringRedisTemplate.opsForValue().increment(key, delta);
    }
}
