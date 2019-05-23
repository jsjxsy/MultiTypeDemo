package com.example.multitypedemo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multitypedemo.R;
import com.example.multitypedemo.model.Ad;

import me.drakeet.multitype.ItemViewBinder;

public class ADViewBinder extends ItemViewBinder<Ad,ADViewBinder.ADViewHolder> {
    @NonNull
    @Override
    protected ADViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View rootView = inflater.inflate(R.layout.layout_item_view_ad, parent, false);
        return new ADViewHolder(rootView);
    }

    @Override
    protected void onBindViewHolder(@NonNull ADViewHolder holder, @NonNull Ad item) {
        if(item == null){
            return;
        }
        holder.imageView.setImageResource(item.icon);
        holder.textView.setText(item.title);
        holder.textSubView.setText(item.subTitle);
    }

    public class ADViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textSubView;
        public ADViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_title);
            textView = itemView.findViewById(R.id.tv_title);
            textSubView = itemView.findViewById(R.id.tv_sub_title);
        }
    }
}
