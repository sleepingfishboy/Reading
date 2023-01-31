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

import com.example.reading.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：sleepingfishboy
 * 时间：2023/1/14
 */
public class NoteTakingActivity extends Activity {
    EditText mEtTakeNote;
    Button mBtnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_taking);
        mEtTakeNote = findViewById(R.id.et_note_take);

    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_HOME){
            return true;
        }
        else if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent();
            intent.putExtra("content", mEtTakeNote.getText().toString());
            intent.putExtra("time", dateToStr());
            setResult(RESULT_OK, intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public String dateToStr(){
        //记录的时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.d("ggg","(:)-->> "+date);
        return simpleDateFormat.format(date);

    }

}
