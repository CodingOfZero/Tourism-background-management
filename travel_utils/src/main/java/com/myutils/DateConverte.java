package com.myutils;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器，将2011-1-1这种格式的数据正确识别为日期，springmvc本身能够识别2011/1/1这种类别
 */

public class DateConverte implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if(s==null){
            throw new RuntimeException("未传入数据");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return  dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }
}
