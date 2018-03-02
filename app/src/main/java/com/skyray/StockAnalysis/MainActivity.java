package com.skyray.StockAnalysis;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.skyray.StockAnalysis.Core.MyLogManager;
import com.skyray.StockAnalysis.DataModel.Messages;
import com.skyray.StockAnalysis.Utils.FullScreenController;
import com.skyray.StockAnalysis.Utils.SystemTimeShower;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private final String TAG = getClass().getName();

    /**
     * 切换显示子窗体方法
     * @param c 子窗体方法
     */
    public void showChildActivity(Class c){
        Intent intent = new Intent(MainActivity.this,c);
        startActivity(intent);
    }

    /**
     * 切换显示子窗体方法
     * @param c 子窗体方法
     */
    public void showChildActivity(Class c,Intent intent){
        startActivity(intent);
    }

    /**
     * 显示业绩快报界面
     * @param
     */
    public void showReportActivity(){
        showChildActivity(ActivityReport.class);
    }

    /**
     * 显示诊股专家界面
     * @param
     */
    public void showDiagnoseActivity(){
        showChildActivity(ActivityDiagnose.class);
    }

    public void showDrawerMenu(){
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyLogManager.addLogInfo("系统启动");

        initAllControls();

        SystemTimeShower.getSystemTimeShower().startShowSystemTime(handler);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SystemTimeShower.getSystemTimeShower().stopShowSystemTime();
    }

    @Override
    public void onBackPressed() {
        SugarORMApp.exit(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            FullScreenController.hideNavigationBar(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDrawerMenu:
                showDrawerMenu();
                break;
            default:
                break;
        }
    }

    private DrawerLayout mDrawerLayout;
    private NavigationView navView;

    private ImageButton btnDrawerMenu;

    //时间显示文本
    private TextView tvSystemTime;

    private void initAllControls(){
        //侧菜单
        mDrawerLayout =  (DrawerLayout)findViewById(R.id.drawer_layout);
        navView = (NavigationView)findViewById(R.id.nav_view) ;
        //主界面导航按钮
        btnDrawerMenu = (ImageButton) findViewById(R.id.btnDrawerMenu);

        //主界面程序退出按钮
        btnDrawerMenu.setOnClickListener(this);

        //时间显示文本
        tvSystemTime = (TextView) findViewById(R.id.tvSystemTime);

        //设置选中item 这里默认不选中
        //navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //取消被选中状态
                item.setChecked(false);
                mDrawerLayout.closeDrawers();
                switch(item.getItemId()){
                    case R.id.menu_item_activity_report:
                        showReportActivity();
                        break;
                    case R.id.menu_item_activity_diagnose:
                        showDiagnoseActivity();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    private  void showSystemTime(Object msg){
        if(msg != null){
            tvSystemTime.setText(msg.toString());
        }
    }

    Handler handler = new Handler(){
        public void handleMessage(Message msg){

            switch(msg.what){
                case Messages.ShowSystemTime_Msg:
                    showSystemTime(msg.obj);
                    break;
                default:
                    break;
            }
        }
    };

}
