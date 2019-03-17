package com.rumwei.enums;

public enum ApproximateType {
    ROUND_DOWN_不论正负_直接舍弃小数部分,
    ROUND_UP_不论正负_对小数部分进1,
    ROUND_CEILING_正数_则小数部分进1_负数_则舍弃小数部分,
    ROUND_FLOOR_正数_则舍弃小数部分_负数_则小数部分进1,
    ROUND_HALF_UP_不论正负_若舍弃部分大于或等于零点五_则进1,
    ROUND_HALF_DOWN_不论正负_若舍弃部分大于零点五_则进1,
    ROUND_HALF_EVEN_看若舍弃部分最左边数_若为偶数_则舍弃部分大于零点五才进1_若为奇数_则舍弃部分大于或等于零点五_则进1
}
