package com.rumwei.util;

import com.rumwei.enums.DateType;

import java.text.SimpleDateFormat;

/*
* 该类逻辑作为本工程的辅助逻辑，不提供外部API使用
* */
class PriCommon {

    static SimpleDateFormat getSimpleDateFormatFromDateType(DateType dateType){
        SimpleDateFormat dateFormat = null;
        if (dateType == DateType.YM){
            dateFormat = new SimpleDateFormat("yyyy-MM");
        }else if (dateType == DateType.YMD){
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }else if (dateType == DateType.YMDHMS){
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }else if (dateType == DateType.YMDHMSSSS){
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
        return dateFormat;
    }




}
