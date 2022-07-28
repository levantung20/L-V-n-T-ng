package com.example.demo.dto;

import java.util.Date;

public class DateConvert {
    public static Date convertLongToDate(Long agr){
        Date date = new Date(agr);
        return date;
    }
}
