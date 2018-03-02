package com.skyray.StockAnalysis;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by linyuan on 2017/11/20 0020.
 */

/**
 * 仪表维护 片段界面基类
 */
public class FragmentBase extends Fragment {

    protected  void onInit(){

    }

    protected void onFinalize(){

    }

    /**
     * 界面ID
     */
    protected  int layoutID = 0;

    private View rootView = null;

    protected View getRootView(){return rootView;};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView == null){
            rootView = inflater.inflate(layoutID,container,false);
        }
        onInit();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onFinalize();
    }
}
