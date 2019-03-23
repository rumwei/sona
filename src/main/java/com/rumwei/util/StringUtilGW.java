package com.rumwei.util;


import com.rumwei.enums.DateType;
import com.rumwei.enums.DeleteType;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class StringUtilGW {

    /*
    * @Param: String input
    * @Return: Integer
    * */
    public static Integer StringToInteger(String input){
        if (input != null){
            return Integer.parseInt(input);
        }else {
            log.error("input is null");
        }
        return null;
    }

    /*
    * @Param: String input
    * @Return: BigDecimal
    * */
    public static BigDecimal StringToBigDecimal(String input){
        if (input != null){
            return new BigDecimal(input);
        }else {
            log.error("input is null");
        }
        return null;
    }






    /*
     * @Param： String input -- 要处理的字符串
     *          String sample -- 要移除的字符串
     *          DeleteType -- 移除字符串的方式-移除结尾，移除开头，移除所有
     * @Return: String result
     * @Info: 移除input中的特定字符串，并返回处理后的字符串结果
     * */
    public static String removeParicularString(String input, String sample, DeleteType deleteType){
        String result = input;
        if (input != null && sample != null && input.length() > sample.length() && sample.length() > 0){
            if (deleteType == DeleteType.DeleteTailString){  //若input以sample字符串作为结尾，则删除该结尾
                String tail = input.substring(input.length()-sample.length());
                if (tail.equalsIgnoreCase(sample)){
                    result = input.substring(0,input.length()-sample.length());
                }
            }else if (deleteType == DeleteType.DeleteHeadString){  //若input以sample字符串作为开头，则删除该开头字符串
                String head = input.substring(0,sample.length());
                if (head.equalsIgnoreCase(sample)){
                    result = input.substring(sample.length());
                }
            }else if (deleteType == DeleteType.DeleteAllString){
                result = input.replaceAll(sample,"");
            }
        }
        return result;
    }


    /*
    * @Param: String
    * @Return: Calendar
    * @Info: 将String转成的Calendar日期
    * */
    public static Calendar stringToCalendar(String input, DateType dateType) throws ParseException {
        SimpleDateFormat dateFormat = PriCommon.getSimpleDateFormatFromDateType(dateType);
        Date date = dateFormat.parse(input);
        Calendar result = Calendar.getInstance();
        result.setTime(date);
        return result;
    }






}
