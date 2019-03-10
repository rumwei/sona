package com.rumwei.typeconvert;


import java.math.BigDecimal;

public class TypeConvert {

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
}
