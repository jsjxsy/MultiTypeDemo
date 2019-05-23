package com.example.multitypedemo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.multitypedemo.R;
import com.example.multitypedemo.model.EmptyValue;

import me.drakeet.multitype.ItemViewBinder;

public class GoodTitleViewBinder extends ItemViewBinder<EmptyValue, GoodTitleViewBinder.GoodTitleViewHolder> {

    @NonNull
    @Override
    protected GoodTitleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_item_view_good_title,parent, false);
        return new GoodTitleViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull GoodTitleViewHolder holder, @NonNull EmptyValue item) {
        holder.textView.setText("商品推荐");
    }

    class GoodTitleViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public GoodTitleViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_good_title);
        }
    }

}
