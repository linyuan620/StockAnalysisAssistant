package com.skyray.StockAnalysis.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by linyuan on 2017/11/14 0014.
 */

public class DateTimeFormater {

    final static String myTimeFormat = "yyyy-MM-dd kk:mm:ss";

    static SimpleDateFormat timeFormater = null;

    static SimpleDateFormat getFormater(){
        if(timeFormater == null){
            timeFormater = new SimpleDateFormat(myTimeFormat);
        }
        return timeFormater;
    }

    public static String getTimeString(Date dt){
        String dtText = getFormater().format(dt);
        return dtText;
    }

    public static Date toDate(String s) throws Exception{
        Date date = new Date();

        try{
            date = getFormater().parse(s);
        }catch(Exception e){
            throw e;
        }
        return date;
    }

}
