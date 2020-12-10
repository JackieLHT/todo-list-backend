package com.oocl.todoList.DTO;

public class TodoRequest {
    private String text;
    private boolean done;
    private String[] tags;

    public TodoRequest(String text, boolean done, String[] tags) {
        this.text = text;
        this.done = done;
        this.tags = tags;
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
