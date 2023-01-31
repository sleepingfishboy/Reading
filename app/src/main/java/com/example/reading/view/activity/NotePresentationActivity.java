package com.example.reading.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.reading.R;
import com.example.reading.view.Note;
import com.example.reading.view.NoteOperating;
import com.example.reading.view.adapter.NoteAdapter;
import com.example.reading.view.repository.NoteDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者：sleepingfishboy
 * 时间：2023/1/14
 */
public class NotePresentationActivity extends AppCompatActivity {

    FloatingActionButton mBtnEstablish;

    private ListView mLvList;
    private NoteDatabase dbHelper;

    private Context context = this;
    private NoteAdapter adapter;
    private String content;
    private String time;

    private List<Note> noteList = new ArrayList<Note>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notepresentation);
        mBtnEstablish = findViewById(R.id.btn_note_establish);

        adapter = new NoteAdapter(getApplicationContext(),noteList);
        mLvList = findViewById(R.id.lv_note_list);
        refreshListView();
        mLvList.setAdapter(adapter);

        mBtnEstablish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到笔记的界面
                Intent intent = new Intent(NotePresentationActivity.this, NoteTakingActivity.class);
                startActivityForResult(intent, 0);//跳转到笔记的界面
            }
        });
    }

    //接收startActivityForResult的结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        String content = data.getStringExtra("content");
        String time = data.getStringExtra("time");
        Note note = new Note(content, time, 1);
        NoteOperating op = new NoteOperating(context);
        op.open();
        op.addNote(note);
        op.close();
        refreshListView();

    }



    public void refreshListView(){

        NoteOperating op = new NoteOperating(context);
        op.open();
        if (noteList.size() > 0) noteList.clear();
        noteList.addAll(op.getAllNotes());
        op.close();
        adapter.notifyDataSetChanged();
    }
}