package com.skyray.StockAnalysis;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.skyray.StockAnalysis.Adapter.ForeCastPanelListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sysu.zyb.panellistlibrary.PanelListLayout;

/**
 * 业绩预告界面
 */

public class FragmentReport_ForeCast extends FragmentBase {

    private PanelListLayout pl_root;
    private ListView lv_content;
    private ForeCastPanelListAdapter adapter;
    private List<Map<String, String>> contentList = new ArrayList<>();

    public FragmentReport_ForeCast() {
        layoutID = R.layout.fragment_report_forecast;
    }

    @Override
    protected void onInit() {

        System.out.println("forecast onInit!");
        initView();
        initContentDataList();

        adapter = new ForeCastPanelListAdapter(getContext(), pl_root, lv_content, R.layout.forecast_item_content, contentList);
        adapter.setInitPosition(0);
        adapter.setSwipeRefreshEnabled(true);
        adapter.setRowDataList(getRowDataList());
        adapter.setTitle("报表");
        adapter.setRowDivider(getResources().getDrawable(R.drawable.row_item_divider));
        //adapter.setColumnDivider(getResources().getDrawable(R.drawable.row_item_divider));
        adapter.setOnRefreshListener(new CustomRefreshListener());
        pl_root.setAdapter(adapter);

    }

    @Override
    protected void onFinalize() {
        super.onFinalize();
    }

    private void initView() {

        pl_root = (PanelListLayout) getRootView().findViewById(R.id.id_pl_root);
        lv_content = (ListView) getRootView().findViewById(R.id.id_lv_content);

        //设置listView为多选模式，长按自动触发
        //lv_content.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        //lv_content.setMultiChoiceModeListener(new MultiChoiceModeCallback());

        //listView的点击监听
        lv_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "你选中的position为：" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class CustomRefreshListener implements SwipeRefreshLayout.OnRefreshListener{
        @Override
        public void onRefresh() {
            // do sth here, example:
            //Toast.makeText(MainActivity.this, "custom SwipeRefresh listener", Toast.LENGTH_SHORT).show();
            adapter.getSwipeRefreshLayout().setRefreshing(false);// don`t forget to call this
        }
    }

    /** 生成一份横向表头的内容
     *
     * @return List<String>
     */
    private List<String> getRowDataList(){
        List<String> rowDataList = new ArrayList<>();
        rowDataList.add("index");
        rowDataList.add("code");
        rowDataList.add("name");
        rowDataList.add("report_date");
        rowDataList.add("content");
        rowDataList.add("range");
        rowDataList.add("notice_date");
        rowDataList.add("range_avg");
        rowDataList.add("netp_profit");
        rowDataList.add("mktcap");
        rowDataList.add("pb");
        rowDataList.add("fpe");
        rowDataList.add("fpeg");
        rowDataList.add("froe");

        return rowDataList;
    }

    /**
     * 初始化content数据
     */
    private void initContentDataList() {
        contentList.clear();
        for (int i = 1; i < 22; i++) {
            Map<String, String> data = new HashMap<>();
            data.put("index", "第" + i + "行第1个");
            data.put("code", "第" + i + "行第2个");
            data.put("name", "第" + i + "行第3个");
            data.put("report_date", "第" + i + "行第4个");
            data.put("content", "第" + i + "行第5个");
            data.put("range", "第" + i + "行第6个");
            data.put("notice_date", "第" + i + "行第7个");
            data.put("range_avg", "第" + i + "行第8个");
            data.put("netp_profit", "第" + i + "行第9个");
            data.put("mktcap", "第" + i + "行第10个");
            data.put("pb", "第" + i + "行第11个");
            data.put("fpe", "第" + i + "行第12个");
            data.put("fpeg", "第" + i + "行第13个");
            data.put("froe", "第" + i + "行第14个");

            contentList.add(data);
        }
    }
}
