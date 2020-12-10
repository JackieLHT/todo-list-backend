package com.oocl.todoList.Controller;

import com.oocl.todoList.DTO.TodoResponse;
import com.oocl.todoList.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TagController {
    @Autowired
    private TodoService todoService;

//    @GetMapping
//    public List<TodoResponse> getTodos() {
//
//    }

}
