package com.example.reading.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.reading.R;

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
        mBtnBack = findViewById(R.id.btn_note_back);


        

    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_HOME){
        return true;
        }
        else if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent();
            intent.putExtra("input",mEtTakeNote.getText().toString());
            setResult(RESULT_OK,intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
