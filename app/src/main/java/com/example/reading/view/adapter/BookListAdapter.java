package com.example.reading.view.adapter;

import android.accessibilityservice.AccessibilityService;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reading.view.GetTextItem;

/**
 * 作者：sleepingfishboy
 * 时间：2023/1/29
 */
public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.InnerHolder> {

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setData(GetTextItem getTextItem) {

    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
 