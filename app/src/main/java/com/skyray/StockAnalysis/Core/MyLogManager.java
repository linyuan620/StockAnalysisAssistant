package com.skyray.StockAnalysis.Core;


import com.skyray.StockAnalysis.DataModel.LogInfo;
import com.skyray.StockAnalysis.Utils.DateOperator;
import com.skyray.StockAnalysis.Utils.DateTimeFormater;

import java.util.Date;
import java.util.List;


/**
 * Created by linyuan on 2017/11/18 0018.
 */

public class MyLogManager {

    public static void addLogInfo(LogInfo logInfo){
        if(logInfo != null){
            logInfo.save();
        }
    }

    public static void addLogInfo(String msg){
        LogInfo log = new LogInfo();
        log.setLogTime(DateOperator.getNow());
        log.setMessage(msg);
        log.save();
    }

    public List<LogInfo> getAllLogInfo(){
        return LogInfo.listAll(LogInfo.class);
    }

    public List<LogInfo> getLogInfoByTime(Date begin, Date end){
        return LogInfo.find(LogInfo.class,"log_Time between ? and ?",
                DateTimeFormater.getTimeString(begin),DateTimeFormater.getTimeString(end));
    }

}
