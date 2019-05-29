package com.rumwei.util;

import com.rumwei.common.DateCommonGW;
import com.rumwei.enums.DateType;
import com.rumwei.enums.LeftType;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Slf4j
public class CalendarUtilGW {

    public static String calendarToString(Calendar calendar, DateType dateType){
        SimpleDateFormat dateFormat = PriCommon.getSimpleDateFormatFromDateType(dateType);
        String result = dateFormat.format(calendar.getTime());
        return result;
    }

    public static Calendar getYMDOnly(Calendar input){
        Calendar calendar = Calendar.getInstance();
        calendar.set(input.get(Calendar.YEAR),input.get(Calendar.MONTH),input.get(Calendar.DATE),0,0,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar;
    }

    /*
    * @Description 计算later-early的天数
    * @Input early later 表示需要计算的两个日期
    * @Input LeftType  LeftType.LeftAsOne表示不足一天部分算一天，LeftType.LeftAsZero表示不足一天的部分不算
    * @Return 相隔的天数，>0表示later在early之后，小于0则相反
    * */
    public static long getDaysBetweenCalendar(Calendar early, Calendar later, LeftType leftType){
        if (leftType == LeftType.LeftAsOne){
            if ((later.getTimeInMillis()-early.getTimeInMillis()) % DateCommonGW.MillionSecondPerDay > 0){
                return (later.getTimeInMillis()-early.getTimeInMillis())/DateCommonGW.MillionSecondPerDay+1;
            }
        }
        return (later.getTimeInMillis()-early.getTimeInMillis())/DateCommonGW.MillionSecondPerDay;
    }

    /*
     * @Description 计算later-early的小时数
     * @Input early later 表示需要计算的两个日期
     * @Input LeftType  LeftType.LeftAsOne表示不足一小时部分算一小时，LeftType.LeftAsZero表示不足一小时的部分不算
     * @Return 相隔的小时数，>0表示later在early之后，小于0则相反
     * */
    public static long getHoursBetweenCalendar(Calendar early, Calendar later, LeftType leftType){
        if (leftType == LeftType.LeftAsOne){
            if ((later.getTimeInMillis() - early.getTimeInMillis()) % DateCommonGW.MillionSecondPerHour > 0){
                return (later.getTimeInMillis()-early.getTimeInMillis())/DateCommonGW.MillionSecondPerHour+1;
            }
        }
        return (later.getTimeInMillis()-early.getTimeInMillis())/DateCommonGW.MillionSecondPerHour;
    }

    /*
     * @Description 比较两个日期的年月日，即不考虑时分秒
     * 40>31保证月份的差距不会因为日期差距被弥补，12*40=480<600保证年份差距不会被月份弥补
     * */
    public static int compareDateOnly(Calendar early, Calendar late){
        int earlyNum = early.get(Calendar.YEAR)*600+early.get(Calendar.MONTH)*40+early.get(Calendar.DATE);
        int lateNum = late.get(Calendar.YEAR)*600+late.get(Calendar.MONTH)*40+late.get(Calendar.DATE);
        if (earlyNum < lateNum) return 1;
        else if (earlyNum == lateNum) return 0;
        else return -1;
    }


    /*
     * @Description 比较两个日期的年月日是否相同
     * */
    public static boolean isEqualInDateLevel(Calendar cal1, Calendar cal2){
        return compareDateOnly(cal1,cal2) == 0;
    }





}
