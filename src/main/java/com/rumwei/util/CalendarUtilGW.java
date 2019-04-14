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





}
