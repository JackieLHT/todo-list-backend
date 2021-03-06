package com.oocl.todoList.Service;

import com.oocl.todoList.Model.Tag;
import com.oocl.todoList.Model.Todo;
import com.oocl.todoList.Repository.TagRepository;
import com.oocl.todoList.Repository.TodoRepository;
import com.oocl.todoList.Exception.TodoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TagRepository tagRepository;
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getById(String todoId) {
        return todoRepository.findById(todoId).orElseThrow(() -> new TodoNotFoundException());
    }

    public Todo update(String todoId, Todo todoUpdate) {
        Todo todo = getById(todoId);
        todoUpdate.setId(todo.getId());
        return todoRepository.save(todoUpdate);
    }

    public void delete(String todoId) {
        Todo todo = getById(todoId);
        todoRepository.deleteById(todo.getId());
    }

    public List<Tag> getTagsByTodoId(String todoId) {
        Todo todo = getById(todoId);
        List<String> tagIds = todo.getTagIds();
        Iterable<Tag> tags = tagRepository.findAllById(tagIds);
        return StreamSupport
                .stream(tags.spliterator(), false)
                .collect(Collectors.toList());
    }
}
