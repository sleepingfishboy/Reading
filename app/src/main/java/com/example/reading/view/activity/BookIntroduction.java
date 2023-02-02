package com.example.reading.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.reading.R;
import com.example.reading.view.GetTextItem;
import com.google.gson.Gson;

public class BookIntroduction extends AppCompatActivity {
    private Button mBtnAdd;
    private TextView mTvName;
    private TextView mTvAuthor;
    private TextView mTvIntroduction;
    private ImageView mIvBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_book_introduction);

        initView();

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookIntroduction.this, NotePresentationActivity.class);
                startActivity(intent);
            }
        });

    }
    private void initView() {
        mBtnAdd = findViewById(R.id.btn_book_add);
        mTvName = findViewById(R.id.tv_book_introduction_name);
        mTvAuthor = findViewById(R.id.tv_book_introduction_author);
        mTvIntroduction = findViewById(R.id.tv_book_introduction);
        Intent intent = getIntent();
        String json = intent.getStringExtra("json");
        Gson gson = new Gson();
        GetTextItem getTextItem = gson.fromJson(json, GetTextItem.class);
        mIvBook = findViewById(R.id.iv_book);
        mTvName.setText(getTextItem.getData().getName());


        mTvAuthor.setText(getTextItem.getData().getAuthor());
        mTvIntroduction.setText(getTextItem.getData().getDescription());
        Glide.with(this).load(getTextItem.getData().getPhotoUrl()).into(mIvBook);


    }
}