package com.skyray.StockAnalysis.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by linyuan on 2017/11/15 0015.
 */

public class AlertDialogManager {
    /**
     * 提示框
     * @param context
     * @param message 信息
     * @param cancelHandler 点击取消执行代码
     * @param confirmHandler 点击确定执行代码
     */

    public static void showDialog (Context context, String message ,
                                   DialogInterface.OnClickListener cancelHandler,
                                   DialogInterface.OnClickListener confirmHandler){
        /*
          这里使用了 android.support.v7.app.AlertDialog.Builder
          可以直接在头部写 import android.support.v7.app.AlertDialog
          那么下面就可以写成 AlertDialog.Builder
          */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage(message);
        builder.setNegativeButton("取消",cancelHandler);
        builder.setPositiveButton("确定",confirmHandler);
        builder.show();
    }

    /**
     *只处理点击事件对话框
     * @param context
     * @param message 提示信息
     * @param confirmHandler 点击确认执行代码
     */

    public static void showDialog(Context context,String message ,
                                  DialogInterface.OnClickListener confirmHandler){
        showDialog(context, message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        },confirmHandler);
    }
}
