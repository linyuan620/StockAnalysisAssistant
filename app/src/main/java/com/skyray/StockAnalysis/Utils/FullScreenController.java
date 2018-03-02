package com.skyray.StockAnalysis.Utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by linyuan on 2017/11/15 0015.
 */

public class FullScreenController {

    /**
     * 不显示标题栏,并且将导航菜单隐藏
     * @param activity 要处理的窗口
     */

        public static void setNoTitleAndHideNavigationBar(Activity activity){
            //无title
            activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
            //全屏
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                    ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

    /**
     * 隐藏指定窗口导航菜单
     * @param activity 指定的窗口
     */
        public static void hideNavigationBar(Activity activity){
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    //hide nav bar
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;// hide status bar

            if(Build.VERSION.SDK_INT >= 19){
                uiFlags |= 0x00001000;//SYSTEM_UI_FLAG_IMMERSIVE_STICKY: hide
                //navigation bars - compatibility:building
                //API level is lower than 19,use magic number directly for higher API target level
            }else{
                uiFlags |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
            }

            activity.getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        }
}
