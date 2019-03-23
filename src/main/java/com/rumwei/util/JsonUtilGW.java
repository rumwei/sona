package com.rumwei.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;

/*
* @Author: guwei
* @Description: 处理Json相关的逻辑
* @Date: 2019-03-23
* */
@Slf4j
public class JsonUtilGW {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,true);  //parser是否允许单引号来包住属性名称和字符串值。
    }

    /*
    * @author guwei
    * @param json String
    * @return Object
    * @exception
    * @Description 将Json字符串转换成对于对象
    * @Date 2019-03-23
    */
    public static <T> T JsonStringToObject(String jsonStr, Class<T> Class) throws Exception{
        Preconditions.checkNotNull(jsonStr);
        return objectMapper.readValue(jsonStr,Class);
    }



}
