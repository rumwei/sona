package com.rumwei.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayUtilGW {

    public static <T> List<T> arrayToList(T[] t){
        return Arrays.asList(t);
    }

    public static <T> Set<T> arrayToSet(T[] t){
        return new HashSet<>(Arrays.asList(t));
    }
}
