package com.rumwei.util;

import java.sql.Timestamp;
import java.util.Calendar;

public class TimeStampUtilGW {

    public static Calendar timestampToCalendar(Timestamp timestamp){
        Calendar result = Calendar.getInstance();
        result.setTimeInMillis(timestamp.getTime());
        return result;
    }

}
