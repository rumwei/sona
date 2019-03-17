package com.rumwei.util;

import com.rumwei.enums.ApproximateType;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
@Slf4j
public class BigDecimalUtilGW {

    /*
    * @Param: BigDecimal input -- 要处理的BigDecimal数字
    *         int scale -- 最后要保留的位数
    *         ApproximateType -- 采取怎样的规则来做舍入
    * @Return: BigDecimal
    * @Info: 对BigDecimal数据做约等于处理，去除某些小数位
    * */
    public static BigDecimal getApproximateValue(BigDecimal input, int scale, ApproximateType approximateType){
        BigDecimal result = null;
        if (input == null){
            log.error("The BigDecimal to handle is null");
            return result;
        }
        if (scale < 0){
            log.error("The param scale is {}. It is smaller than zero which is not supported. please enter a value grater than zero",scale);
            return result;
        }
        if (approximateType == null){
            log.error("please input a type to approximate");
            return result;
        }

        if (approximateType == ApproximateType.ROUND_CEILING_正数_则小数部分进1_负数_则舍弃小数部分) {
            result = input.setScale(scale, BigDecimal.ROUND_CEILING);
        } else if (approximateType == ApproximateType.ROUND_DOWN_不论正负_直接舍弃小数部分) {
            result = input.setScale(scale, BigDecimal.ROUND_DOWN);
        } else if (approximateType == ApproximateType.ROUND_FLOOR_正数_则舍弃小数部分_负数_则小数部分进1) {
            result = input.setScale(scale, BigDecimal.ROUND_FLOOR);
        } else if (approximateType == ApproximateType.ROUND_HALF_DOWN_不论正负_若舍弃部分大于零点五_则进1) {
            result = input.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
        } else if (approximateType == ApproximateType.ROUND_HALF_EVEN_看若舍弃部分最左边数_若为偶数_则舍弃部分大于零点五才进1_若为奇数_则舍弃部分大于或等于零点五_则进1) {
            result = input.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
        } else if (approximateType == ApproximateType.ROUND_HALF_UP_不论正负_若舍弃部分大于或等于零点五_则进1) {
            result = input.setScale(scale, BigDecimal.ROUND_HALF_UP);
        } else if (approximateType == ApproximateType.ROUND_UP_不论正负_对小数部分进1) {
            result = input.setScale(scale, BigDecimal.ROUND_UP);
        }
        return result;
    }
}
