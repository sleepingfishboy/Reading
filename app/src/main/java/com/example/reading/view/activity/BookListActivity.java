package com.example.reading.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.reading.R;
import com.example.reading.view.GetTextItem;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;


import javax.net.ssl.HttpsURLConnection;

public class BookListActivity extends AppCompatActivity {
    private EditText mEtIsbn;
    private ImageView mIvEnter;
    private BookListAdapter mAdapter;

    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_book_list);

        initView(); //初始化view
        //mHandler = new MyHandler();//准备接线员

        //因为接口要求，请求后要隔两秒才可以继续请求，且一个apikey一天最多接受来自5个ip的请求，一旦超过，将会禁止当天该apikey的所有请求

        mIvEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendGetNetRequest();
//                Intent intent = new Intent(BookListActivity.this, NotePresentationActivity.class);
//                startActivity(intent);
            }
        });

    }

    private void initView() {
        mIvEnter = findViewById(R.id.iv_book_enter);
        mEtIsbn = findViewById(R.id.et_book_isbn);
        RecyclerView recyclerView = findViewById(R.id.rv_book_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BookListAdapter();
        recyclerView.setAdapter(mAdapter);

    }


    public void sendGetNetRequest() {
        new Thread(
                () -> {
                    try {
                        String isbn = mEtIsbn.getText().toString().trim();

                        String mUrl = "https://api.jike.xyz/situ/book/isbn/" + isbn + "?apikey=14768.f8d5763973746ae6fd0e912190f33195.cd9e64ec1e9c28664054f0f8918274ca";

                        URL url = new URL(mUrl);
                        Log.d("ggg", "(:)-->> " + "666");

                        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                        connection.setConnectTimeout(10000);//设置最大连接时间，单位为ms
                        connection.setReadTimeout(8000);//设置最大的读取时间，单位为ms
                        connection.setRequestMethod("GET");//设置请求方式为GET
                        connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
                        connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                        connection.connect();

                        int responseCode = connection.getResponseCode();
                        if (responseCode == 200) {
                            Map<String, List<String>> headerFields = connection.getHeaderFields();
                            Set<Map.Entry<String, List<String>>> entries = headerFields.entrySet();
                            for (Map.Entry<String, List<String>> entry : entries) {

                            }
                            InputStream inputStream = connection.getInputStream();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                            String json = bufferedReader.readLine();
                            Log.d("ggg", "(:)-->> jjj" + json);
                            Gson gson = new Gson();
                            GetTextItem getTextItem = gson.fromJson(json, GetTextItem.class);
                            getTextItem.getData().getName();
                            Log.d("ggg", "(:)-->> 名字" + getTextItem.getData().getName());
                            SharedPreferences sp=getSharedPreferences("json",Context.MODE_PRIVATE);
                            SharedPreferences.Editor eit=sp.edit();
                            eit.putString(json,json);
                            eit.apply();
                            updateUI(getTextItem);//更新UI
                            if (json != null) {
                                Intent intent = new Intent(BookListActivity.this, BookIntroduction.class);
                                intent.putExtra("json", json);
                                startActivity(intent);

                            } else Toast.makeText(this, "!获取数据失败", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        ).start();

    }

    private void updateUI(GetTextItem getTextItem) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.setData(getTextItem);
            }
        });
    }


}