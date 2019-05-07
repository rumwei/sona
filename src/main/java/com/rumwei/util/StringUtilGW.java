package com.rumwei.util;


import com.rumwei.enums.DateType;
import com.rumwei.enums.DeleteType;
import com.rumwei.exception.runtime.BizException;
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

    public static boolean isNullOrEmpty(String input){
        return input == null || input.length() == 0;
    }

    public static boolean isNotNullOrEmpty(String input){
        return !isNullOrEmpty(input);
    }


    /*
    * @Param: String input  --要处理的字符串
    *         DeleteType    --移除字符串的方式：移除结尾 & 移除开头
    *         Character...  --要移除的字符串，字符串由这些单个字符任意组合构成
    * @Return: 移除后的结果
    * @Info: 移除由characters里包含的字符任意组合成的字符串
    * @eg: 假设传入a,0,+ 则移除的字符串为a0,a,aa,00,++,aa00+0a等字符，假设处理"0a++00bi00+iu",且DeleteType为开头字符，则返回bi00+iu
    * */
    public static String trimStartOrEnd(String input, DeleteType deleteType, Character... characters) throws Exception{
        String result = "";
        if (input == null || characters == null || characters.length == 0) return result;
        //region 利用characters构建正则表达式
        StringBuilder regexB = new StringBuilder();
        regexB.append("[");
        for (int i=0; i<characters.length; i++){
            if (i < characters.length-1){
                regexB.append(characters[i]).append("|");
            }else {
                regexB.append(characters[i]);
            }
        }
        regexB.append("]*");
        String regex = regexB.toString();
        //endregion

        if (input.matches(regex)) return result;
        if (deleteType == DeleteType.DeleteHeadString){
            //删除前字符
            int begin = 0;
            int end = input.length();
            while (begin < end){
                int mid = (begin+end)/2;
                if (input.substring(0,mid).matches(regex)){
                    begin = mid;
                }else{
                    end = mid;
                }
                if (end - begin == 1){
                    break;
                }
            }
            result = input.substring(begin,input.length());
        }else if (deleteType == DeleteType.DeleteTailString){
            //删除后置字符
            int begin = 0;
            int end = input.length();
            while (begin < end){
                int mid = (begin+end)/2;
                if (input.substring(mid,end).matches(regex)){
                    end = mid;
                }else{
                    begin = mid;
                }
                if (end - begin == 1){
                    break;
                }
            }
            result = input.substring(0,end);
        }else {
            throw new BizException("DeleteType is not support:"+deleteType.toString());
        }
        return result;
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
