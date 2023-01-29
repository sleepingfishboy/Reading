package com.example.reading.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.reading.R;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_splash);

        Thread myThread=new Thread(){//创建子线程
            @Override
            public void run() {
                try{
                    sleep(1000);//使程序休眠2秒
                    Intent it=new Intent(getApplicationContext(), BookListActivity.class);//启动BookList
                    startActivity(it);
                    finish();//关闭
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();//启动
    }

}