package com.example.reading.view;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.reading.view.repository.NoteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：sleepingfishboy
 * 时间：2023/1/31
 */
public class NoteOperating {
    //定义数据库
    //对数据库进行操作
    SQLiteOpenHelper mDbHandler;
    SQLiteDatabase mDb;

    private static final String[] columns = {
            NoteDatabase.ID,
            NoteDatabase.CONTENT,
            NoteDatabase.TIME,
            NoteDatabase.MODE
    };
    //初始化
    public NoteOperating(Context context) {//初始化
        mDbHandler = new NoteDatabase(context);
    }
//数据库访问
    public void open(){
        mDb = mDbHandler.getWritableDatabase();
    }
//数据库关闭
    public void close(){
        mDbHandler.close();
    }

    //把note 加入到database里面
    public Note addNote(Note note){

        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteDatabase.CONTENT, note.getContent());
        contentValues.put(NoteDatabase.TIME, note.getTime());
        contentValues.put(NoteDatabase.MODE, note.getTag());
        long insertId = mDb.insert(NoteDatabase.TABLE_NAME, null, contentValues);//自增长的id
        note.setId(insertId);
        return note;
    }

    public Note getNote(long id){
        //通过id定位note
        Cursor cursor = mDb.query(NoteDatabase.TABLE_NAME, columns, NoteDatabase.ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null) cursor.moveToFirst();
        Note e = new Note(cursor.getString(1), cursor.getString(2), cursor.getInt(3));
        return e;
    }

    @SuppressLint("Range")
    public List<Note> getAllNotes(){
        //在数组中添加数据
        Cursor cursor = mDb.query(NoteDatabase.TABLE_NAME, columns, null, null, null, null, null);

        List<Note> notes = new ArrayList<>();
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Note note = new Note();
                note.setId(cursor.getLong(cursor.getColumnIndex(NoteDatabase.ID)));
                note.setContent(cursor.getString(cursor.getColumnIndex(NoteDatabase.CONTENT)));
                note.setTime(cursor.getString(cursor.getColumnIndex(NoteDatabase.TIME)));
                note.setTag(cursor.getInt(cursor.getColumnIndex(NoteDatabase.MODE)));
                notes.add(note);
            }
        }
        return notes;
    }

    public int updateNote(Note note) {
        //更新笔记
        ContentValues values = new ContentValues();
        values.put(NoteDatabase.CONTENT, note.getContent());
        values.put(NoteDatabase.TIME, note.getTime());
        values.put(NoteDatabase.MODE, note.getTag());
        //updating row
        return mDb.update(NoteDatabase.TABLE_NAME, values,
                NoteDatabase.ID + "=?", new String[] { String.valueOf(note.getId())});
    }

    public void removeNote(Note note){
        //删除笔记
        mDb.delete(NoteDatabase.TABLE_NAME, NoteDatabase.ID + "=" + note.getId(), null);
    }
}
