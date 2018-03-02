package com.skyray.StockAnalysis;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;

import com.orm.SugarContext;
import com.skyray.StockAnalysis.Core.MyLogManager;
import com.skyray.StockAnalysis.Utils.AlertDialogManager;


/**
 * Created by linyuan on 2017/11/15 0015.
 */

/**
 * Sugar ORM 需要实现
 */

public class SugarORMApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }


    public static void exit(Context c){
        AlertDialogManager.showDialog(c, "确定退出?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyLogManager.addLogInfo("程序退出");
                int id = android.os.Process.myPid();
                android.os.Process.killProcess(id);
            }
        });
    }

}
