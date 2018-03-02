package com.skyray.StockAnalysis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.skyray.StockAnalysis.Utils.FullScreenController;
import java.util.HashMap;

public class ActivityReport extends BaseActivity{

    public final String TAG = getClass().getName();
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FullScreenController.setNoTitleAndHideNavigationBar(this);
        setContentView(R.layout.activity_report);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //TabLayout
        TabLayout tabLayout  = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ActivityReport.this.finish();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            //FullScreenController.hideNavigationBar(this);
        }
    }

    /**
     *仪表维护子菜单类型
     */
    enum ReportType{
        ForeCast(0),FastReport(1),Report(2);

        private int _value;

        ReportType(int value){_value = value;};

        public int value(){return _value;};

        public static ReportType valueOf(int value){
            switch(value){
                case 0:
                    return ForeCast;
                case 1:
                    return FastReport;
                case 2:
                    return Report;
                default:
                    return null;
            }
        }
    }

    HashMap<ReportType,FragmentBase> fragments = new HashMap<>();

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ReportType reportType = ReportType.valueOf(position);
            if(!ActivityReport.this.fragments.containsKey(reportType)){
                FragmentBase fragment = null;
                switch(reportType){
                    case ForeCast:
                        fragment = new FragmentReport_ForeCast();
                        break;
                    case FastReport:
                        fragment = new FragmentReport_FastReport();
                        break;
                    case Report:
                        fragment = new FragmentReport_Report();
                        break;
                    default:
                        break;
                }
                ActivityReport.this.fragments.put(reportType,fragment);
            }
            return ActivityReport.this.fragments.get(reportType);
        }

        @Override
        public int getCount() {
            return ReportType.values().length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            ReportType reportType = ReportType.valueOf(position);
            switch (reportType){
                case ForeCast:
                    return getResources().getString(R.string.e_ForeCast);
                case FastReport:
                    return getResources().getString(R.string.e_FastReport);
                case Report:
                    return getResources().getString(R.string.e_Report);
            }
            return null;
        }
    }
}
