package com.wyl.xue.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName: JacksonUntils
 * @Function: jackson 的工具类
 * @Date: 2019/12/16 14:06
 * @author wangyl
 * @version V1.0
 */
public class JacksonUtil {
    public static final ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description 将一个对象转换为json字符串
     * @param obj
     * @return java.lang.String
     * @Date 2019/12/16 14:10
     * @Author wangyl
     * @Version  V1.0
     */
    public static String toJSONString(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    /**
     * @Description 将一个json样式的字符串 转换为一个指定对象
     * @param json json样式的字符串
     * @param clazz 需要转换成的对象
     * @return T
     * @Date 2019/12/16 14:10
     * @Author wangyl
     * @Version  V1.0
     */
    public static <T> T toClassObject(String json, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }
}
