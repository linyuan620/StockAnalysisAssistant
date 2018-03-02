package com.skyray.StockAnalysis.DataModel;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.skyray.StockAnalysis.Utils.DateTimeFormater;


import java.util.Date;


/**
 * Created by linyuan on 2017/11/14 0014.
 */

public class LogInfo extends SugarRecord {
    @NotNull
    private Date logTime = null;
    @NotNull
    private String message = "";

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return DateTimeFormater.getTimeString(logTime) + "\t\t" + message;
    }
}
