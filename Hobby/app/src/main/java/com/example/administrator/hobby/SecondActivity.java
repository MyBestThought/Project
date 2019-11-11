package com.example.administrator.hobby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/11/2 0002.
 */

public class SecondActivity extends AppCompatActivity {
    private ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");//接受姓名
        final String work = intent.getStringExtra("work");//接受职业
        String sex = intent.getStringExtra("sex");//接受性别
        String status = intent.getStringExtra("status");//接受当前婚姻状况
        String hobby = intent.getStringExtra("hobby");


        List<String> list = new ArrayList<>();
        list.add("姓名是： " + name);
        list.add("性别是： " + sex);
        list.add("职业是： " +  work);
        list.add("婚姻状况是： " + status);
        list.add("爱好是： " + hobby);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }


}
