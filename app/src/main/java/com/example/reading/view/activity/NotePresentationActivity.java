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
public class NotePresentationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

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

        adapter = new NoteAdapter(getApplicationContext(), noteList);
        mLvList = findViewById(R.id.lv_note_list);
        refreshListView();
        mLvList.setAdapter(adapter);
        mLvList.setOnItemClickListener(this);//让ListView可以点击

        mBtnEstablish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到笔记的界面
                Intent intent = new Intent(NotePresentationActivity.this, NoteTakingActivity.class);
                intent.putExtra("mode", 4);

                startActivityForResult(intent, 0);//跳转到笔记的界面
            }
        });
    }

    //接收startActivityForResult的结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        int returnMode;
        long note_Id;
        returnMode = data.getExtras().getInt("mode", -1);
        note_Id = data.getExtras().getLong("id", 0);

        if (returnMode == 1) {
            //更新当前笔记

            String content = data.getExtras().getString("content");
            String time = data.getExtras().getString("time");
            int tag = data.getExtras().getInt("tag", 1);

            Note newNote = new Note(content, time, tag);
            newNote.setId(note_Id);
            NoteOperating op = new NoteOperating(context);
            op.open();
            op.updateNote(newNote);
            op.close();
        } else if (returnMode == 0) {
            //新建笔记

            String time = data.getStringExtra("time");

            int tag = data.getExtras().getInt("tag", 1);
            Note newNote = new Note(content, time, tag);
            NoteOperating op = new NoteOperating(context);
            op.open();
            op.addNote(newNote);
            op.close();

        }else{

    }
        refreshListView();
        super.onActivityResult(requestCode, resultCode, data);

    }


    public void refreshListView() {

        NoteOperating op = new NoteOperating(context);
        op.open();
        if (noteList.size() > 0) noteList.clear();
        noteList.addAll(op.getAllNotes());
        op.close();
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //设置点击事件
        switch (parent.getId()) {
            case R.id.lv_note_list:
                Note curNote = (Note) parent.getItemAtPosition(position);
                Intent intent = new Intent(NotePresentationActivity.this, NoteTakingActivity.class);
                intent.putExtra("content", curNote.getContent());
                intent.putExtra("id", curNote.getId());
                intent.putExtra("time", curNote.getTime());
                intent.putExtra("mode", 3);
                intent.putExtra("tag", curNote.getTag());
                startActivityForResult(intent, 1);

                break;
        }
    }
}