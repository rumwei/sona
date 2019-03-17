package com.rumwei.util;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapUtilGW {

    /*
    * 构建一个Map<String,String>对象，key为key+i,value为value+i，其中1<=i<=num
    * @Info: 底层为HashMap
    * */
    public static Map<String,String> generateMapString(String key, String value, int num){
        Map<String,String> result = new HashMap<String, String>();
        for (int i=1; i<=num; i++){
            result.put(key+i,value+i);
        }
        return result;
    }

    /*
     * 构建一个Map<Integer,Integer>对象，key为i,value为i，其中1<=i<=num
     * @Info: 底层为HashMap
     * */
    public static Map<Integer,Integer> generateMapInteger(int num){
        Map<Integer,Integer> result = new HashMap<Integer, Integer>();
        for (int i=1; i<=num; i++){
            result.put(i,i);
        }
        return result;
    }


}
