package com.example.workshop;

public class NoteInfos {
    private long id;
    private String title;
    private String content;

    NoteInfos(String title,String content){
        this.title = title;
        this.content = content;
    }

    NoteInfos(long id,String title,String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
    NoteInfos(){
        // empty constructor
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
