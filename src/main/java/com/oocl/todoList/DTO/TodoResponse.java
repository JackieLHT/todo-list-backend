package com.oocl.todoList.DTO;

public class TodoResponse {
    private String id;
    private String text;
    private boolean done;
    private String[] tags;

    public TodoResponse() {}

    public TodoResponse(String id, String text, boolean done, String[] tags) {
        this.id = id;
        this.text = text;
        this.done = done;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
