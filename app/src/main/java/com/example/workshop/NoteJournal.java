package com.example.workshop;

public class NoteJournal {
    private long id;
    private String content;
    private String date;
    private String time;

    NoteJournal(String content,String date, String time){
        this.content = content;
        this.date = date;
        this.time = time;
    }

    NoteJournal(long id,String content,String date, String time){
        this.id = id;
        this.content = content;
        this.date = date;
        this.time = time;
    }
    NoteJournal(){
        // empty constructor
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
