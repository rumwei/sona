package com.rumwei.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetUtilGW {

    /*
    * convert set to array
    * */
    public static <T> T[] setToArray(Set<T> set, Class clazz){
        Object obArray = Array.newInstance(clazz,set.size());
        T[] result = (T[])obArray;
        int i = 0;
        for (T t : set){
            result[i++] = t;
        }
        return result;
    }

    /*
    * convert Set to List
    * */
    public static List setToList(Set set){
        return new ArrayList<>(set);
    }


}
