package com.vue.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @PackageName:com.vue.util
 * @Date:2019/9/3 17:26
 * @Author: zsy
 * 封装jackson，传入对象返回json字符串
 */
public class JsonUtil {
    /**
     * 使用jackson 转换 json 数据的第一步
     */
    private static ObjectMapper MAPPER = new ObjectMapper();
    static String jsonString=null;

    public static String toJSON(Object object){
        try {
            /**
             * jackson转任意object对象 为json 字符串
             */
            jsonString = MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
