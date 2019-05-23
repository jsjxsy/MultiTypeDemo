package com.example.multitypedemo;

import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.multitypedemo.model.Title;

import java.util.ArrayList;

import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_design;
    private MultiTypeAdapter adapter;
    private ArrayList<Title> list;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_design = findViewById(R.id.rv_design);

        rv_design.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MultiTypeAdapter();
        adapter.register(Title.class, new TitleViewBinder());

        rv_design.setAdapter(adapter);
        list = new ArrayList<>();

        list.add(new Title("title 1", Icon.createWithResource(this,R.mipmap.ic_launcher)));//模拟的初始化数据，伪代码
        list.add(new Title("title 2", Icon.createWithResource(this,R.mipmap.ic_launcher)));//模拟的初始化数据，伪代码
        list.add(new Title("title 3", Icon.createWithResource(this,R.mipmap.ic_launcher)));//模拟的初始化数据，伪代码
        list.add(new Title("title 4", Icon.createWithResource(this,R.mipmap.ic_launcher)));//模拟的初始化数据，伪代码
        list.add(new Title("title 5", Icon.createWithResource(this,R.mipmap.ic_launcher)));//模拟的初始化数据，伪代码
        list.add(new Title("title 6", Icon.createWithResource(this,R.mipmap.ic_launcher)));//模拟的初始化数据，伪代码
        list.add(new Title("title 7", Icon.createWithResource(this,R.mipmap.ic_launcher)));//模拟的初始化数据，伪代码

        adapter.setItems(list);
        adapter.notifyDataSetChanged();
    }


}
