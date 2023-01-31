package com.example.reading.view;

/**
 * 作者：sleepingfishboy
 * 时间：2023/1/31
 */
public class Note {
    private long id;//每条笔记的id，每条笔记的id都独一无二
    private String content;//内容
    private String time;//记录的时间
    private int tag;//笔记类别，方便以后对软件优化

    public Note(){

    }

    public Note(String content, String time, int tag){
        this.content = content;
        this.time = time;
        this.tag = tag;
    }

//get和set
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return content + "\n" + time.substring(5,16) + " " + id;
    }
}
