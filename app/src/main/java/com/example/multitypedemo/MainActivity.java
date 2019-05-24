package com.example.multitypedemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.multitypedemo.Adapter.ADViewBinder;
import com.example.multitypedemo.Adapter.BannerViewBinder;
import com.example.multitypedemo.Adapter.GoodTitleViewBinder;
import com.example.multitypedemo.Adapter.GoodViewBinder;
import com.example.multitypedemo.Adapter.LineViewBinder;
import com.example.multitypedemo.Adapter.TitleViewBinder;
import com.example.multitypedemo.model.Ad;
import com.example.multitypedemo.model.Banner;
import com.example.multitypedemo.model.EmptyValue;
import com.example.multitypedemo.model.Good;
import com.example.multitypedemo.model.GoodList;
import com.example.multitypedemo.model.Title;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ClassLinker;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_design;
    private MultiTypeAdapter adapter;
    private ArrayList<Object> list;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_design = findViewById(R.id.rv_design);

//        rv_design.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new MultiTypeAdapter();
//        adapter.register(Title.class, new TitleViewBinder());
//
//        rv_design.setAdapter(adapter);
//        list = new ArrayList<>();
//        adapter.setItems(list);
//        adapter.notifyDataSetChanged();


        final int num_banner = 1;
        final int num_title = 5;
        final int num_ad = 2;
        final int num_good_title = 1;
        final int num_good = 1;
//        final int num_hot = 1;
//        final int num_main_game = 1;
//        final int num_new_title = 1;
//        final int num_new_game = 2;

        int[] types = new int[]{num_banner, num_title, num_ad, num_good_title,num_good};//, num_good, num_hot};
        final int total = MockData.getTotal(types);

        /**每一行占的个数不固定的例子
         * 比如有一行1个，5个，2个 同时存在
         * 全部相乘是10
         * 第一种 SpanSize=10/1
         * 第二种 SpanSize=10/5
         * 第三种 SpanSize=10/2
         * 为什么呢？因为要保证10/1 10/5 10/2 都是整数。
         */
        GridLayoutManager layoutManager = new GridLayoutManager(this, total);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                if (list.get(position) instanceof Banner) {
                    return total / num_banner;
                }
                if (list.get(position) instanceof Title) {
                    return total / num_title;
                }
                if (list.get(position) instanceof Ad) {
                    return total / num_ad;
                }
                if (list.get(position) instanceof EmptyValue) {
                    return total / num_good_title;
                }
                if (list.get(position) instanceof Good) {
                    return total / num_good;
                }
//                if (list.get(position) instanceof HotList) {
//                    return total / num_hot;
//                }
//                if (list.get(position) instanceof MainGame) {
//                    return total / num_main_game;
//                }
                return total;
            }
        });
        rv_design.setLayoutManager(layoutManager);

        adapter = new MultiTypeAdapter();

        adapter.register(Banner.class, new BannerViewBinder());
        adapter.register(Title.class, new TitleViewBinder());
        adapter.register(Ad.class, new ADViewBinder());
        adapter.register(EmptyValue.class)
                .to(new GoodTitleViewBinder(),
                        new LineViewBinder())
                .withClassLinker(new ClassLinker<EmptyValue>() {
                    @NonNull
                    @Override
                    public Class<? extends ItemViewBinder<EmptyValue, ?>> index(@NonNull EmptyValue emptyValue) {
                        if (emptyValue.type == EmptyValue.TYPE_GOODTITLE) {
                            return GoodTitleViewBinder.class;
                        }
                        if (emptyValue.type == EmptyValue.TYPE_LINE) {
                            return LineViewBinder.class;
                        }
                        return LineViewBinder.class;
                    }
                });
        adapter.register(GoodList.class, new GoodViewBinder());
//        adapter.register(HotList.class, new HotViewBinder());
//        adapter.register(MainGame.class, new MainGameViewBinder());
        rv_design.setAdapter(adapter);
        list = new ArrayList<>();
        MockData.init(list);
        adapter.setItems(list);
        adapter.notifyDataSetChanged();
    }


}
