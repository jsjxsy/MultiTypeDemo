package com.example.multitypedemo;


import com.example.multitypedemo.model.Ad;
import com.example.multitypedemo.model.Banner;
import com.example.multitypedemo.model.EmptyValue;
import com.example.multitypedemo.model.Title;

import java.util.List;

public class MockData {
    public static void init(List<Object> list) {
        //banner
        list.add(new Banner("url"));

        //title
        list.add(new Title("title 1", R.mipmap.ic_launcher));//模拟的初始化数据，伪代码
        list.add(new Title("title 2", R.mipmap.ic_launcher));//模拟的初始化数据，伪代码
        list.add(new Title("title 3", R.mipmap.ic_launcher));//模拟的初始化数据，伪代码
        list.add(new Title("title 4", R.mipmap.ic_launcher));//模拟的初始化数据，伪代码
        list.add(new Title("title 5", R.mipmap.ic_launcher));//模拟的初始化数据，伪代码

        //Ad
        list.add(new Ad("title 1", "sub title", R.mipmap.ic_launcher));//模拟的初始化数据，伪代码
        list.add(new Ad("title 2", "sub title 2", R.mipmap.ic_launcher));//模拟的初始化数据，伪代码
        //line
        list.add(new EmptyValue(EmptyValue.TYPE_LINE));
        list.add(new EmptyValue(EmptyValue.TYPE_GOODTITLE));

    }
}
