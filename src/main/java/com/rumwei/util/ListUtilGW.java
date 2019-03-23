package com.rumwei.util;

import com.google.common.collect.Lists;
import com.rumwei.base.ConditionGW;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
* List相关的处理类，针对所有List以及入参为List的所有情况
* */
public class ListUtilGW {


    /*
    * 创建一个ArrayList
    * */
    public static <E> ArrayList<E> newArrayList(){
        return Lists.newArrayList();
    }
    /*
    * 基于入参elements构建一个ArrayList
    * */
    public static <E> ArrayList<E> newArrayList(E... elements){
        return Lists.newArrayList(elements);
    }



    /*
     * 创建一个ArrayList
     * */
    public static <E> LinkedList<E> newLinkedList(){
        return Lists.newLinkedList();
    }
    /*
     * 基于入参elements构建一个ArrayList
     * */
    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> elements){
        return Lists.newLinkedList(elements);
    }

    /*
    * 移除List中符号条件的元素
    * 具体条件在ConditionGW的实现类中表示
    * */
    public static <E> List<E> removeEles(List<E> inputList, ConditionGW<E,Boolean> condition){
        return inputList.stream().filter(p->!condition.apply(p)).collect(Collectors.toList());
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
     * @Param： List<T> input 入参
     *          int segmentSize 每个分段的大小
     * @Info: 将入参List按每段segmentSize个元素的数目进行分割
     * */
    public static <T> List<List<T>> ListSplit(List<T> input, int segmentSize){
        return Lists.partition(input,segmentSize);
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

}
