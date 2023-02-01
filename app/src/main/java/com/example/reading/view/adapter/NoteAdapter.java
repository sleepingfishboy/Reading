package com.example.reading.view.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.reading.R;
import com.example.reading.view.Note;

import java.util.List;


/**
 * 作者：sleepingfishboy
 * 时间：2023/1/31
 */
public class NoteAdapter extends BaseAdapter implements Filterable {
    private Context mContext;

    private List<Note> backList;//用来备份原始数据
    private List<Note> noteList;//这个数据是会改变的，所以要有个变量来备份一下原始数据
    private MyFilter mFilter;

    public NoteAdapter(Context mContext, List<Note> noteList) {
        this.mContext = mContext;
        this.noteList = noteList;
        backList = noteList;
    }
    @Override
    public Filter getFilter() {
        if (mFilter == null){
            mFilter = new MyFilter();
        }
        return mFilter;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return noteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        View v = View.inflate(mContext, R.layout.note_layout, null);
        TextView tv_content = v.findViewById(R.id.tv_content);
        TextView tv_time = v.findViewById(R.id.tv_time);


        String allText = noteList.get(position).getContent();

        tv_content.setText(allText);
        tv_time.setText(noteList.get(position).getTime());


        v.setTag(noteList.get(position).getId());

        return v;


    }

    class MyFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            return null;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

        }
    }
}
