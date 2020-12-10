package com.oocl.todoList.ServiceTest;

import com.oocl.todoList.Model.Todo;
import com.oocl.todoList.Repository.TodoRepository;
import com.oocl.todoList.Service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @InjectMocks
    private TodoService todoService;
    @Mock
    private TodoRepository todoRepository;

    @Test
    public void should_return_all_todos_when_getAll_given_all_todos() {
        final Todo task1 = new Todo("task1", false,new ArrayList<>());
        final Todo task2 = new Todo("task2", false,new ArrayList<>());
        final List<Todo> todos = new ArrayList<>();
        todos.add(task1);
        todos.add(task2);

        when(todoRepository.findAll()).thenReturn(todos);

        List<Todo> actual = todoService.getAll();

        assertEquals(todos, actual);

    }

    @Test
    public void should_return_new_todo_when_create_given_new_todo() {
        final Todo task = new Todo("task2", false, new ArrayList<>());
        task.setId("1");

        when(todoRepository.save(task)).thenReturn(task);

        Todo actual = todoService.create(task);

        assertEquals(task, actual);

    }

    @Test
    public void should_return_specific_todo_when_getById_given_todoId() {
        final Todo task = new Todo("task2", false, new ArrayList<>());
        task.setId("1");

        when(todoRepository.findById(task.getId())).thenReturn(java.util.Optional.of(task));

        Todo actual = todoService.getById("1");

        assertEquals(task, actual);

    }

    @Test
    public void should_return_updated_todo_when_update_given_todoId_and_request_info() {
        final Todo task = new Todo("task2", false, new ArrayList<>());
        task.setId("1");
        final Todo expected = new Todo("task2 editted", false, new ArrayList<>());

        when(todoRepository.save(task)).thenReturn(task);

        Todo actual = todoService.update("1",expected);

        assertEquals(expected, actual);

    }
}
