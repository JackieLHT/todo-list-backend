package com.oocl.todoList.DTO;

import com.oocl.todoList.Model.Tag;

import java.util.List;

public class TodoResponse {
    private String id;
    private String text;
    private boolean done;
    private List<TagResponse> tags;

    public TodoResponse() {}

    public TodoResponse(String id, String text, boolean done, List<TagResponse> tags) {
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

    public List<TagResponse> getTags() {
        return tags;
    }

    public void setTags(List<TagResponse> tags) {
        this.tags = tags;
    }
}
