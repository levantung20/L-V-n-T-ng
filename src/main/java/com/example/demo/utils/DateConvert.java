package com.example.demo.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateConvert {
    public static Date convertLongToDate(Long agr) {
        Date date = new Date(agr);
        return date;
    }
    public static String convertReplyCommentToString(Long createdDate) {
        long timeNow = System.currentTimeMillis();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(timeNow - createdDate);
        if (minutes > 60) {
           return minutes / 60 + " hour";
        }
        if (minutes > 60 * 24) {
            return minutes / (60 * 24) + " day";
        }
        if (minutes < 60) {
            return minutes + " minutes";
        }
        return "Just comment";
    }
}
