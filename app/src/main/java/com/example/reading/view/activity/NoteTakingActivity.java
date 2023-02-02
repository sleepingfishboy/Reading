package com.example.reading.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.example.reading.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：sleepingfishboy
 * 时间：2023/1/14
 */
public class NoteTakingActivity extends Activity {
    EditText mEtTakeNote;
    private String old_content = "";
    private String old_time = "";
    private int old_Tag = 1;
    private long id = 0;
    private int openMode = 0;
    private int tag = 1;
    public Intent intent = new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_taking);

        mEtTakeNote = findViewById(R.id.et_note_take);
        Intent getIntent = getIntent();
        int openMode = getIntent.getIntExtra("mode", 0);

        if (openMode == 3) {//打开已存在的note
            id = getIntent.getLongExtra("id", 0);
            old_content = getIntent.getStringExtra("content");
            old_time = getIntent.getStringExtra("time");
            old_Tag = getIntent.getIntExtra("tag", 1);
            mEtTakeNote.setText(old_content);
            mEtTakeNote.setSelection(old_content.length());

        }

    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_HOME){
            return true;
        }
        else if (keyCode == KeyEvent.KEYCODE_BACK){
            autoSetMessage();
            setResult(RESULT_OK, intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }





    public void autoSetMessage(){
        if(openMode == 4){
            if(mEtTakeNote.getText().toString().length() == 0){
                intent.putExtra("mode", -1); //nothing new happens.
            }
            else{
                intent.putExtra("mode", 0); // new one note;
                intent.putExtra("content", mEtTakeNote.getText().toString());
                intent.putExtra("time", dateToStr());
                intent.putExtra("tag", tag);
            }
        }
        else {
            if (mEtTakeNote.getText().toString().equals(old_content))
                intent.putExtra("mode", -1); // edit nothing
            else {
                intent.putExtra("mode", 1); //edit the content
                intent.putExtra("content", mEtTakeNote.getText().toString());
                intent.putExtra("time", dateToStr());
                intent.putExtra("id", id);
                intent.putExtra("tag", tag);
            }
        }
    }



    public String dateToStr() {
        //记录的时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//yyyy-MM-dd HH:mm:ss
        Log.d("ggg", "(:)-->> " + date);
        return simpleDateFormat.format(date);

    }

}
