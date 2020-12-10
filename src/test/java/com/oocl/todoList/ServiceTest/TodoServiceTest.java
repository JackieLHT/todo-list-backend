package com.oocl.todoList.ServiceTest;

import com.oocl.todoList.Model.Tag;
import com.oocl.todoList.Model.Todo;
import com.oocl.todoList.Repository.TagRepository;
import com.oocl.todoList.Repository.TodoRepository;
import com.oocl.todoList.Service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @InjectMocks
    private TodoService todoService;
    @Mock
    private TodoRepository todoRepository;
    @Mock
    private TagRepository tagRepository;

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

        when(todoRepository.save(any(Todo.class))).thenReturn(expected);
        when(todoRepository.findById("1")).thenReturn(Optional.of(task));

        Todo actual = todoService.update("1",expected);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getText(), actual.getText());
        assertEquals(expected.isDone(), actual.isDone());
        assertEquals(expected.getTagIds(), actual.getTagIds());

    }

    @Test
    public void should_delete_todo_when_delete_given_todoId() {
        final Todo task = new Todo("task2", false, new ArrayList<>());
        task.setId("1");

        when(todoRepository.findById("1")).thenReturn(Optional.of(task));

        todoService.delete("1");
        //then
        verify(todoRepository, times(1)).deleteById("1");

    }

    @Test
    public void should_return_all_tags_of_specific_todo_when_getTagsByTodoId_given_todoId() {
        Tag tag1 = new Tag("tag1","blue");
        Tag tag2 = new Tag("tag2","green");
        tag1.setId("1");
        tag2.setId("2");
        List<String> tagIds = Arrays.asList("1","2");
        List<Tag> tags = new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);
        final Todo todo = new Todo("task2", false, tagIds);
        todo.setId("1");

        when(todoRepository.findById("1")).thenReturn(Optional.of(todo));
        when(tagRepository.findAllById(tagIds)).thenReturn(tags);

        List<Tag> acutal = todoService.getTagsByTodoId("1");
        //then
        assertEquals(tags.get(0),acutal.get(0));
        assertEquals(tags.get(1),acutal.get(1));

    }
}
