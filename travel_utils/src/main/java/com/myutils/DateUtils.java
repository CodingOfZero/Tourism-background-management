package com.myutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换工具类
 */
public class DateUtils {
    //日期转换为字符串
    public static String dateToString(Date date,String pattern){
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        String format=sdf.format(date);
        return format;
    }
    //字符串转换为日期
    public static Date stringToDate(String str,String pattern) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        Date parse=sdf.parse(str);
        return parse;
    }
}
