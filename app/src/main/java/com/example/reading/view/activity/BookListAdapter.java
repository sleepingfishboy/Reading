package com.example.reading.view.activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reading.R;
import com.example.reading.view.GetTextItem;

import java.util.ArrayList;

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
//        nameTv.setText(getTextItem.getData().getName());
//        Glide.with(itemView.getContext()).load(getTextItem.getData().getPhotoUrl()).into(bookIv);
    }



    @Override
    public int getItemCount() {
        return 1;
    }

    public void setData(GetTextItem getTextItem) {
        getTextItem.getData();
        getTextItem.getData().getAuthor();
        Log.d("ggg","(:)-->> aaaaaaaaaaaaaaaaaaaaaaaaaa");
        Log.d("ggg","(:)-->> "+getTextItem.getData().getAuthor());
        getTextItem.getData().getPhotoUrl();
        getTextItem.getData().getName();
        notifyDataSetChanged();

    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
 