package com.example.reading.view.adapter;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.reading.R;
import com.example.reading.view.GetTextItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：sleepingfishboy
 * 时间：2023/1/29
 */
public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.InnerHolder> {
    GetTextItem.DataBean mData = new GetTextItem.DataBean();


    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_rv, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        View itemView = holder.itemView;
        TextView nameTv = itemView.findViewById(R.id.tv_item_book_name);
        ImageView bookIv = itemView.findViewById(R.id.iv_item_book);
        nameTv.setText(mData.getName());
        Glide.with(itemView.getContext()).load(mData.getPhotoUrl()).into(bookIv);
    }



    @Override
    public int getItemCount() {
        return 1;
    }

    public void setData(GetTextItem getTextItem) {


        mData.getAuthor();
        mData.getPhotoUrl();
        mData.getName();

    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
 