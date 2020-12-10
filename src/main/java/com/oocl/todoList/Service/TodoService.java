package com.oocl.todoList.Service;

import com.oocl.todoList.Model.Todo;
import com.oocl.todoList.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getById(String todoId) {
        return todoRepository.findById(todoId).orElse(null);
    }

    public Todo update(String todoId, Todo todoUpdate) {
        return null;
    }
}
