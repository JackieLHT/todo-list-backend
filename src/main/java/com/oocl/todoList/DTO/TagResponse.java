package com.oocl.todoList.DTO;

public class TagResponse {
    private String id;
    private String text;
    private String color;

    public TagResponse() {}

    public TagResponse(String id, String text, String color) {
        this.id = id;
        this.text = text;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
