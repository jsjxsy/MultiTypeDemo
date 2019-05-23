package com.example.multitypedemo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.multitypedemo.R;
import com.example.multitypedemo.model.Banner;

import me.drakeet.multitype.ItemViewBinder;

public class BannerViewBinder extends ItemViewBinder<Banner, BannerViewBinder.BannerViewHolder> {
    @NonNull
    @Override
    protected BannerViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_item_view_banner, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull BannerViewHolder holder, @NonNull Banner item) {
        if(item == null){
            return;
        }
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
    }


    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public BannerViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.id_image_banner);
        }
    }
}
