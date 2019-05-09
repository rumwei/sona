package com.rumwei.util;

import com.google.common.collect.Lists;
import com.rumwei.base.ComparatorGW;
import com.rumwei.base.ConditionGW;
import com.rumwei.base.ConvertGW;
import com.rumwei.common.DataTypeCommonGW;
import com.rumwei.enums.OrderType;
import com.rumwei.exception.runtime.BizException;
import javax.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/*
* List相关的处理类，针对所有List以及入参为List的所有情况
* */
@Slf4j
public class ListUtilGW {

    /*
    * @Input: List<E>， String separator
    * @Return: String
    * @Description： 将入参List<E>中的每个元素转换成一个字符串，然后利用输入的separator分隔符串成一个字符串
    * @eg： List: 2 3 4; separator: &  输出 2&3&4
    * */
    public static <E> String ListEleToString(List<E> input, String separator, ConvertGW<E,String> convert){
        StringBuffer result = new StringBuffer();
        if (!isNullOrEmpty(input)){
            for (int i=0; i<input.size(); i++){
                if (i < input.size()-1){
                    result.append(convert.apply(input.get(i))).append(separator);
                }else {
                    result.append(convert.apply(input.get(i)));
                }
            }
        }
        return result.toString();
    }


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

    public static boolean isNull(List input){
        return input == null;
    }

    public static boolean isNullOrEmpty(List input){
        return (input == null || input.size() == 0);
    }

    public static boolean isNotNullOrEmpty(List input){
        return !isNullOrEmpty(input);
    }

    /*
    * convert list to array
    * */
    public static <T> T[] listToArray(List<T> list, Class clazz){
        Object obArray = Array.newInstance(clazz,list.size());
        T[] result = (T[])obArray;
        for (int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    /*
    * convert List to Set
    * */
    public static Set listToSet(List list){
        return new HashSet(list);
    }

    /*
    * List元素去重
    * 针对去重元素为复杂对象的说明：
    * 如下方法中已经实现的是时间复杂度比较高（10000对象大概2000ms左右的去重时间），但是结果准确的方式
    * 若去重的集合size巨大，且对性能要求很高，则推荐复写相应对象的hashCode和equal方法，然后借助Set集合来做去重操作，基本可以达到上述性能的40倍
    * */
    public static <T> List<T> duplicateRemove(List<T> list, ComparatorGW<T> comparator, @Nonnull OrderType orderType){
        if (list.size() > 10000){
            log.warn("去重集合数目已超过10000，若为非基本类型对象去重，请慎重使用该方法，10000数据量去重时间在2000ms作用");
        }
        List<T> result = newArrayList();
        if (!isNullOrEmpty(list)){
            if (DataTypeCommonGW.isBasicTypeOrString(list.get(0))){
                //ele is Basic Data Type or String Type
                Set<T> set = null;
                if (orderType == OrderType.OrderSense) {
                    set = new LinkedHashSet<>();
                    set.addAll(list);
                }else if (orderType == OrderType.OrderNonSense){
                    set = new HashSet<>();
                    set.addAll(list);
                }else {
                    log.error("please input correct OrderType; Only OrderType.OrderSense and OrderType.OrderNonSense is valid.");
                    throw new BizException("please input correct OrderType; Only OrderType.OrderSense and OrderType.OrderNonSense is valid.");
                }
                result.addAll(set);
            }else {
                //ele is Object
                if (orderType == OrderType.OrderSense) {
                    for (int i = 0; i < list.size(); i++) {
                        boolean mark = false;
                        for (T t : result) {
                            if (comparator.compare(t, list.get(i)) == 0) {
                                mark = true;
                                break;
                            }
                        }
                        if (!mark) {  //no same ele exist yet
                            result.add(list.get(i));
                        }

                    }
                }else {
                    log.error("please input correct OrderType; With Object Only OrderType.OrderSense is valid.");
                    throw new BizException("please input correct OrderType; Only OrderType.OrderSense is valid.");
                }
            }
        }
        return result;
    }

}
