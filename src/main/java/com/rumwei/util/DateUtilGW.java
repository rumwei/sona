package com.rumwei.util;

import com.rumwei.enums.LeftType;

import java.util.Calendar;
import java.util.Date;

public class DateUtilGW {

    public static Calendar dateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static int getYear(Date date){
        return dateToCalendar(date).get(Calendar.YEAR);
    }

    public static int getMonth(Date date){
        return dateToCalendar(date).get(Calendar.MONTH);
    }

    public static int getDay(Date date){
        return dateToCalendar(date).get(Calendar.DATE);
    }

    /*
     * @Description 计算later-early的天数
     * @Input early later 表示需要计算的两个日期
     * @Input LeftType  LeftType.LeftAsOne表示不足一天部分算一天，LeftType.LeftAsZero表示不足一天的部分不算
     * @Return 相隔的天数，>0表示later在early之后，小于0则相反
     * */
    public static long getDaysBetweenDate(Date early, Date later, LeftType leftType){
        return CalendarUtilGW.getDaysBetweenCalendar(dateToCalendar(early),dateToCalendar(later),leftType);
    }

    /*
     * @Description 计算later-early的小时数
     * @Input early later 表示需要计算的两个日期
     * @Input LeftType  LeftType.LeftAsOne表示不足一小时部分算一小时，LeftType.LeftAsZero表示不足一小时的部分不算
     * @Return 相隔的小时数，>0表示later在early之后，小于0则相反
     * */
    public static long getHoursBetweenDate(Date early, Date later, LeftType leftType){
        return CalendarUtilGW.getHoursBetweenCalendar(dateToCalendar(early),dateToCalendar(later),leftType);
    }



}
