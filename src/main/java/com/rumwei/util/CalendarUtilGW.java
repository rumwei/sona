package com.rumwei.util;

import com.rumwei.enums.DateType;
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

}
