package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static Date convertStringToDate(Long date) throws ParseException {
        Date date1 = new Date(date);
        return new SimpleDateFormat("yyyy/MM/dd")
                .parse(date1.toString());
    }
}
