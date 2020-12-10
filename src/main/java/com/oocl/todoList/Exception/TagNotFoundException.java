package com.oocl.todoList.Exception;

public class TagNotFoundException extends RuntimeException{

    public static final String TAG_NOT_FOUND = "Tag Not Found.";

    public TagNotFoundException() {
        super(TAG_NOT_FOUND);
    }
}
