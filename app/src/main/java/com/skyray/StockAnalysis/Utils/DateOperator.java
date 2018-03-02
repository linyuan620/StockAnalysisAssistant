package com.skyray.StockAnalysis.Utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by linyuan on 2017/11/15 0015.
 */

public class DateOperator {

    //add 方法:根据日历的规则，为给定的日历字段添加或减去指定的时间量。
    public static Date addMinute(Date value ,int add){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        calendar.add(Calendar.MINUTE , add);
        return calendar.getTime();
    }

    public static Date addDay(Date value,int add){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        calendar.add(Calendar.DATE,add);
        return calendar.getTime();
    }
    //getTime() 返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 Date 对象。
    //getTimeInMillis() 返回此 Calendar 的时间值，以毫秒为单位
    public static Date getNow(){
        return Calendar.getInstance().getTime();
    }

    public static Date getDate(int year ,int month,int day,int hour ,int minute ,int second){
        return new Date(year,month,day,hour,minute,second);
    }

    public static double getDateMinuteSub(Date one,Date two){
        return (one.getTime() - two.getTime()) / (60*1000);
    }

    public static double getDateDaySub(Date one ,Date two){
        return (one.getTime() - two.getTime()) / (24 * 60 * 60 * 1000);
    }

    public static double getDateHourSub (Date one ,Date two){
        double between = one.getTime() - two.getTime();

        return between / (24 * 60 * 60 * 1000) ; //这里和彭的算法不同
    }

}
