package com.oocl.todoList.DTO;

import java.util.List;

public class TodoRequest {
    private String text;
    private boolean done;
    private List<String> tagIds;

    public TodoRequest(String text, boolean done, List<String> tagIds) {
        this.text = text;
        this.done = done;
        this.tagIds = tagIds;
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

    public List<String> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<String> tagIds) {
        this.tagIds = tagIds;
    }
}
