package com.oocl.todoList.Controller;

import com.oocl.todoList.DTO.TagResponse;
import com.oocl.todoList.DTO.TodoResponse;
import com.oocl.todoList.Mapper.TodoMapper;
import com.oocl.todoList.Model.Todo;
import com.oocl.todoList.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
public class TagController {
    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoMapper todoMapper;

    @GetMapping
    public List<TodoResponse> getTodos() {
        return todoService.getAll().stream().map(todoMapper::todoResponse).collect(Collectors.toList());
    }

    @GetMapping("/{todoId}")
    public TodoResponse getById(@PathVariable String todoId) {
        Todo todo = todoService.getById(todoId);
        return null;
//        List<TagResponse> todoTags =
    }

}
