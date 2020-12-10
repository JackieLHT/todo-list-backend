package com.oocl.todoList.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Tag {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String text;
    private String color;

    public Tag() {}

    public Tag(String text, String color) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Tag other = (Tag) obj;
        return this.id.equals(other.id) && this.text.equals(other.text) && this.color.equals(other.color);
    }
}
