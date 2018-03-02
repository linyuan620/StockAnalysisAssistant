package com.skyray.StockAnalysis.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 弹出简单提示信息
 */


/**
 * Created by linyuan on 2017/11/15 0015.
 */

public class SimpleMessageShower {

    public static void showMsg(Context context , String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

}
