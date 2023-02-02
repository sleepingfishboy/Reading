package com.example.reading.view.adapter;

import android.content.Context;
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
import com.example.reading.view.Note;
import com.example.reading.view.fruit;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 作者：sleepingfishboy
 * 时间：2023/1/29
 */
public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.InnerHolder> {






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

        nameTv.setText("围城");
        Glide.with(itemView.getContext()).load("https://img2.doubanio.com/view/subject/m/public/s1070222.jpg").into(bookIv);
    }



    @Override
    public int getItemCount() {
        return 1;
    }

    public void setData(GetTextItem getTextItem) {
        getTextItem.getData();

        notifyDataSetChanged();

    }



    public class InnerHolder extends RecyclerView.ViewHolder {

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
 