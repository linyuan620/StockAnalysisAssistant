package com.skyray.StockAnalysis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.skyray.StockAnalysis.Utils.FullScreenController;


/**
 * Created by linyuan on 2017/11/19 0019.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FullScreenController.setNoTitleAndHideNavigationBar(this);
    }
}
