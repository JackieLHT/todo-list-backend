package com.oocl.todoList.Exception;

public class TodoNotFoundException extends RuntimeException{

    public static final String TODO_ITEM_NOT_FOUND = "Todo Item Not Found.";

    public TodoNotFoundException() {
        super(TODO_ITEM_NOT_FOUND);
    }
}
