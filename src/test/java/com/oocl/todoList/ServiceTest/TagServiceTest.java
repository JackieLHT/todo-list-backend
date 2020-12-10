package com.oocl.todoList.ServiceTest;

import com.oocl.todoList.Model.Tag;
import com.oocl.todoList.Repository.TagRepository;
import com.oocl.todoList.Service.TagService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TagServiceTest {
    @InjectMocks
    TagService tagService;
    @Mock
    TagRepository tagRepository;


    @Test
    public void should_return_all_tags_when_getAll_given_all_tags() {
        Tag tag1 = new Tag("tag1","blue");
        Tag tag2 = new Tag("tag2","green");
        List<Tag> tags = new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);
        when(tagRepository.findAll()).thenReturn(tags);

        List<Tag> actual = tagService.getAll();

        assertEquals(tags,actual);
    }
}
