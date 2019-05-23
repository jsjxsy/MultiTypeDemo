package com.example.multitypedemo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.multitypedemo.R;
import com.example.multitypedemo.model.EmptyValue;

import me.drakeet.multitype.ItemViewBinder;

public class LineViewBinder extends ItemViewBinder<EmptyValue, LineViewBinder.LineViewViewHolder> {

    @NonNull
    @Override
    protected LineViewViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_item_view_line, parent, false);
        return new LineViewViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull LineViewViewHolder holder, @NonNull EmptyValue item) {

    }

    public class LineViewViewHolder extends RecyclerView.ViewHolder {

        public LineViewViewHolder(View itemView) {
            super(itemView);
        }
    }
}
