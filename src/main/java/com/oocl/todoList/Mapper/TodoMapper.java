package com.oocl.todoList.Mapper;

import com.oocl.todoList.DTO.TodoRequest;
import com.oocl.todoList.DTO.TodoResponse;
import com.oocl.todoList.Model.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    @Autowired

    public Todo toEntity(TodoRequest todoRequest) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest,todo);
        return todo;
    }

    public TodoResponse todoResponse(Todo todo) {
        TodoResponse todoResponse = new TodoResponse();
        BeanUtils.copyProperties(todo,todoResponse);
        return todoResponse;
    }
}
