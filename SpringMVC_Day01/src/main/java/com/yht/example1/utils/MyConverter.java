package com.yht.example1.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if(s == null){
            throw new RuntimeException("传入的日期为null！！！");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
