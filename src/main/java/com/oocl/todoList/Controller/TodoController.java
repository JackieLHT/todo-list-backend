package com.oocl.todoList.Controller;

import com.oocl.todoList.DTO.TagResponse;
import com.oocl.todoList.DTO.TodoRequest;
import com.oocl.todoList.DTO.TodoResponse;
import com.oocl.todoList.Mapper.TagMapper;
import com.oocl.todoList.Mapper.TodoMapper;
import com.oocl.todoList.Model.Todo;
import com.oocl.todoList.Service.TagService;
import com.oocl.todoList.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class TodoController {
    @Autowired
    private TodoService todoService;
    @Autowired
    private TagService tagService;
    @Autowired
    private TodoMapper todoMapper;
    @Autowired
    private TagMapper tagMapper;

    @GetMapping
    public List<TodoResponse> getTodos() {
        return todoService.getAll().stream().map(todo -> {
            TodoResponse todoResponse = todoMapper.toResponse(todo);
            List<TagResponse> todoTags = todoService.getTagsByTodoId(todo.getId()).stream().map(tagMapper::toResponse).collect(Collectors.toList());
            todoResponse.setTags(todoTags);
            return todoResponse;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{todoId}")
    public TodoResponse getById(@PathVariable String todoId) {
        Todo todo = todoService.getById(todoId);
        TodoResponse todoResponse = todoMapper.toResponse(todo);
        List<TagResponse> todoTags = todoService.getTagsByTodoId(todoId).stream().map(tagMapper::toResponse).collect(Collectors.toList());
        todoResponse.setTags(todoTags);
        return todoResponse;
    }

    @PostMapping
    public TodoResponse create(@RequestBody TodoRequest todoRequest) {
        Todo newTodo = todoService.create(todoMapper.toEntity(todoRequest));
        return todoMapper.toResponse(newTodo);
    }

    @PutMapping("/{todoId}")
    public TodoResponse update(@PathVariable String todoId, @RequestBody TodoRequest todoUpdate) {
        Todo todo = todoService.update(todoId, todoMapper.toEntity(todoUpdate));
        return todoMapper.toResponse(todo);
    }

    @DeleteMapping("/{todoId}")
    public void delete(@PathVariable String todoId) {
        todoService.delete(todoId);
    }
}
