package com.rumwei.common;

public class DataTypeCommonGW {

    /*
    * 判断某个对象是否是基本类型的包装类
    * 基本类型包括char,byte,short,int,long,float,double,不包括boolean
    * */
    public static <T> boolean isBasicType(T t){
        if (t instanceof Character || t instanceof Byte || t instanceof Short || t instanceof Integer
        || t instanceof Long || t instanceof Float || t instanceof Double){
            return true;
        }
        return false;
    }

    /*
     * 判断某个对象是否是基本类型的包装类或String类型
     * 基本类型包括char,byte,short,int,long,float,double,不包括boolean
     * */
    public static <T> boolean isBasicTypeOrString(T t){
        if (isBasicType(t) || t instanceof String){
            return true;
        }
        return false;
    }
}
