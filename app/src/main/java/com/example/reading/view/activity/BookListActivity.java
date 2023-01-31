package com.example.reading.view.activity;

import static java.lang.System.in;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.reading.R;
import com.example.reading.view.GetTextItem;
import com.example.reading.view.adapter.BookListAdapter;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

public class BookListActivity extends AppCompatActivity {
    private EditText mEtIsbn;
    private ImageView mIvEnter;
    private BookListAdapter mAdapter;
    String ISBN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_book_list);

        initView(); //初始化view
        //因为接口要求，请求后要隔两秒才可以继续请求，且一个apikey一天最多接受来自5个ip的请求，一旦超过，将会禁止当天该apikey的所有请求

        mIvEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sendGetNetRequest();

                Intent intent = new Intent(BookListActivity.this, NotePresentationActivity.class);
                startActivity(intent);

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
                            updateUI(getTextItem);//更新UI


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