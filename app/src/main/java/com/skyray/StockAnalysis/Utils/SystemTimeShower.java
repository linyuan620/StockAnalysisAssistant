package com.skyray.StockAnalysis.Utils;

/**
 * Created by linyuan on 2017/11/15 0015.
 */
import android.os.Handler;
import android.os.Message;

import com.skyray.StockAnalysis.DataModel.Messages;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 计时器用于定时向主界面发送系统时间
 */


public class SystemTimeShower {

    private static SystemTimeShower _shower = new SystemTimeShower();

    boolean ifShowingSystemTime = false;

    private Handler _handeler = null;

    boolean ifStopShowSystemTime = false;

    Timer systemTimer = null;

    public static SystemTimeShower getSystemTimeShower(){
        return _shower;
    }

    void onShowSystemTime(){
        if(! ifShowingSystemTime){
            ifShowingSystemTime = true;

            GregorianCalendar ge = new GregorianCalendar();
            Date dt = ge.getTime();
            String dtText = DateTimeFormater.getTimeString(dt);

            Message message = Message.obtain(_handeler , Messages.ShowSystemTime_Msg);
            message.obj = dtText;

            _handeler.sendMessage(message);

            ifShowingSystemTime = false;
        }
    }

    /**
     * 初始化 并开始发送系统时间
     * @param handler
     */
    public void startShowSystemTime(Handler handler){
        _handeler = handler;
        try{
            ifStopShowSystemTime = false;
            systemTimer = new Timer();
            systemTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    SystemTimeShower.this.onShowSystemTime();
                }
            },0,1000);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 停止显示时间
     */
    public void stopShowSystemTime(){
        ifStopShowSystemTime = true;

        if(systemTimer != null){
            systemTimer.cancel();
        }
    }

}
