package com.tamgitsun.tgsapp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TimeUtils {

    static public String getCurDate() {
        DateFormat format = SimpleDateFormat.getDateInstance();
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }

    static public long diffDay(String date1, String date2) {
        long ret = 0;
        DateFormat format = SimpleDateFormat.getDateInstance();
        try {
            Date d1 = format.parse(date1);
            Date d2 = format.parse(date2);
            if (null != d1 && null != d2) {
                long m1 = d1.getTime();
                long m2 = d2.getTime();
                ret = (m2 - m1) / (24 * 60 * 60 * 1000);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
