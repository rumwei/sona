package com.rumwei.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.google.common.base.Preconditions;
import com.rumwei.exception.runtime.BizException;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

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
        try{
            Preconditions.checkNotNull(jsonStr);
            return objectMapper.readValue(jsonStr,Class);
        }catch(InvalidDefinitionException e){
            log.error("Please add default constructor for Class respective to the Object to be converted");
            throw new BizException("Please add default constructor for Class respective to the Object to be converted");
        }catch (Exception e){
            throw e;
        }

    }



    /*
    * @Description 将Json字符串转换成Map对象
    * */
    public static Map<String,Object> JsonStringToMap(String jsonStr) throws Exception{
        Preconditions.checkNotNull(jsonStr);
        return objectMapper.readValue(jsonStr,Map.class);
    }




}
