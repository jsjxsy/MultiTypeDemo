package com.example.multitypedemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.multitypedemo.model.Title;

import me.drakeet.multitype.ItemViewBinder;

public class TitleViewBinder extends ItemViewBinder<Title, TitleViewBinder.TitleHolder> {

    @NonNull
    @Override
    protected TitleHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View rootView = inflater.inflate(R.layout.layout_item_view, parent, false);
        return new TitleHolder(rootView);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onBindViewHolder(@NonNull TitleHolder holder, @NonNull Title item) {
        if (item == null) {
            return;
        }
        holder.imageView.setImageIcon(item.icon);
        holder.textView.setText(item.title);

    }

    static class TitleHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        TitleHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_title);
            textView = (TextView) itemView.findViewById(R.id.tv_title);

        }

    }
}
