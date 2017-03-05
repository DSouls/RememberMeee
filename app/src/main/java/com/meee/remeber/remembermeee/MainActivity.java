package com.meee.remeber.remembermeee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    List<String> data;
    private TimeLineAdapter timeLineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setDividerHeight(0);
        timeLineAdapter = new TimeLineAdapter(this, getData());
        listView.setAdapter(timeLineAdapter);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "这是第1行测试数据");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "这是第2行测试数据");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "这是第3行测试数据");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "这是第4行测试数据");
        list.add(map);

        return list;
    }
}
