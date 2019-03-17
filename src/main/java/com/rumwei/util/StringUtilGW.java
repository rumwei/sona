package com.rumwei.util;


import com.rumwei.enums.DateType;
import com.rumwei.enums.DeleteType;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class StringUtilGW {

    /*
    * @Param: String input
    * @Return: Integer
    * */
    public static Integer StringToInteger(String input){
        if (input != null){
            return Integer.parseInt(input);
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
        }
        return null;
    }

    /*
    * @Param: List<Integer>
    * @Return: String
    * @Info 将List<Integer>拼接起来，分隔符为separator
    * */
    public static String IntegerToString(List<Integer> input, String separator){
        StringBuilder result  = new StringBuilder();
        if (input != null && input.size() > 0) {
            Iterator<Integer> iter = input.iterator();
            while (iter.hasNext()) {
                result.append(iter.next());
                if (iter.hasNext()) {
                    result.append(separator);
                }
            }
        }
        return result.toString();
    }


    /*
    * @Param: String prefix -- 链表字符串前缀
    *         String suffix -- 链表字符串后缀
    *         int num -- 链表元素个数
    * @Return: List<String>
    * @Info: 产生一个字符串链表，个数是num，元素是prefix+i+suffix，其中1 <= i <= num
    *        List底层实现是LinkedList
    * */
    public static List<String> generateStringList(String prefix, String suffix, int num){
        List<String> result = new LinkedList<String>();
        for (int i = 1; i<=num; i++){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(prefix).append(i).append(suffix);
            result.add(stringBuffer.toString());
        }
        return result;
    }

    /*
     * @Param: int num -- 链表元素个数
     * @Return: List<Integer>
     * @Info: 产生一个Integer链表，个数是num，元素是i，其中1 <= i <= num
     *        List底层实现是LinkedList
     * */
    public static List<Integer> generateIntegerList(int num){
        List<Integer> result = new LinkedList<Integer>();
        for (int i=1; i<=num; i++){
            result.add(i);
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




    /*
    * @Param： List<T> input 入参
    *          int segmentSize 每个分段的大小
    * @Info: 将入参List按每段segmentSize个元素的数目进行分割
    * */
    public static <T> List<List<T>> ListSplit(List<T> input, int segmentSize){
        List result = new LinkedList();
        if (input != null && input.size() > 0 && segmentSize > 0) {
            int count = input.size() / segmentSize;
            for (int i = 0; i < count; i++) {
                result.add(input.subList(i * segmentSize, (i + 1) * segmentSize));
                if (i == count-1 && count*segmentSize < input.size()){
                    result.add(input.subList(count * segmentSize, input.size()));
                }
            }
        }
        return result;
    }

}
