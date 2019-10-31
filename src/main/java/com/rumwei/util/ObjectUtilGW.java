package com.rumwei.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;


/*
* @Author: guwei
* @Description: Object常用处理逻辑
* @Date: 2019-03-23
* */
@Slf4j
public class ObjectUtilGW {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES,true);  //parser是否允许单引号来包住属性名称和字符串值。
    }

    /*
    * @author guwei
    * @param Object
    * @return String
    * @exception
    * @Description convert a object to String
    * @Date 2019-03-23
    */
    public static String ObjectToJsonString(Object o) throws Exception{
        Preconditions.checkNotNull(o);
        return objectMapper.writeValueAsString(o);
    }

    public static String toString(Object o, String nullDefault){
        return (o != null) ? o.toString() : nullDefault;
    }




}
