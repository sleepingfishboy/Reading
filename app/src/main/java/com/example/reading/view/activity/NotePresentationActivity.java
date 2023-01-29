package com.example.reading.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.reading.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * 作者：sleepingfishboy
 * 时间：2023/1/14
 */
public class NotePresentationActivity extends AppCompatActivity {

    FloatingActionButton mBtnEstablish;
    TextView mTvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏

        setContentView(R.layout.activity_notepresentation);
        mBtnEstablish = findViewById(R.id.btn_note_establish);
        mTvList = findViewById(R.id.tv_note_list);

        mBtnEstablish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到笔记的界面
                Intent intent = new Intent(NotePresentationActivity.this, NoteTakingActivity.class);
                startActivityForResult(intent, 0);//跳转到笔记的界面
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //接收startActivityForResult的结果
        super.onActivityResult(requestCode, resultCode, data);
        String note = data.getStringExtra("input");
        mTvList.setText(note);
    }
}