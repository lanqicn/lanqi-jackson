package io.lanqi.plus.jackson.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final ObjectMapper DEFAULT_MAPPER = new ObjectMapper();

    /**
     * 将json字符串转换为简单对象：使用自定义的objectMapper
     * @param mapper 自定义objectMapper
     * @param jsonStr json字符串
     * @param clazz 目标对象类
     * @return 目标对象
     * @param <T> 目标对象类型
     */
    public static <T> T parseObj(ObjectMapper mapper, String jsonStr, Class<T> clazz) {
        try {
            return mapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将字符串转换为简单对象：使用默认objectMapper
     * @param jsonStr json字符串
     * @param clazz 目标对象类
     * @return 目标对象
     * @param <T> 目标对象类型
     */
    public static <T> T parseObj(String jsonStr, Class<T> clazz) {
        return parseObj(DEFAULT_MAPPER, jsonStr, clazz);
    }

    /**
     * 将字符串转换为复杂对象（比如泛型对象）:使用自定义objectMapper
     * @param mapper 自定义objectMapper
     * @param jsonStr json字符串
     * @param typeReference 泛型对象的引用
     * @return 复杂泛型对象
     * @param <T> 目标对象类型
     */
    public static <T> T parseObj(ObjectMapper mapper, String jsonStr, TypeReference<T> typeReference) {
        try {
            return mapper.readValue(jsonStr, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 将字符串转换为复杂对象（比如泛型对象）:使用默认objectMapper
     * @param jsonStr json字符串
     * @param typeReference 泛型对象的引用
     * @return 复杂泛型对象
     * @param <T> 目标对象类型
     */
    public static <T> T parseObj(String jsonStr, TypeReference<T> typeReference) {
        return parseObj(DEFAULT_MAPPER, jsonStr, typeReference);
    }

    /**
     * 将对象转换为json字符串：使用自定义objectMapper
     * @param mapper 自定义objectMapper
     * @param obj 待转换的对象
     * @return json字符串
     */
    public static String toJsonStr(ObjectMapper mapper, Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将对象转换为json字符串：使用默认objectMapper
     * @param obj 待转换的对象
     * @return json字符串
     */
    public static String toJsonStr(Object obj) {
        return toJsonStr(DEFAULT_MAPPER, obj);
    }
}
