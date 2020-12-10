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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

    @Test
    public void should_return_specific_tag_when_getById_given_tagId() {
        Tag tag1 = new Tag("tag1","blue");
        tag1.setId("1");
        when(tagRepository.findById(tag1.getId())).thenReturn(java.util.Optional.of(tag1));

        Tag actual = tagService.getById("1");

        assertEquals(tag1,actual);
    }

    @Test
    public void should_return_created_tag_when_create_given_new_tag() {
        Tag tag1 = new Tag("tag1","blue");
        tag1.setId("1");
        when(tagRepository.save(any(Tag.class))).thenReturn(tag1);

        Tag actual = tagService.create(tag1);

        assertEquals(tag1,actual);
    }

    @Test
    public void should_return_updated_tag_when_update_given_tagId_and_request_info() {
        Tag tag1 = new Tag("tag1","blue");
        Tag expected = new Tag("tag1 editted","orange");
        tag1.setId("1");
        when(tagRepository.save(any(Tag.class))).thenReturn(expected);
        when(tagRepository.findById(tag1.getId())).thenReturn(java.util.Optional.of(tag1));

        Tag actual = tagService.update("1",expected);

        assertEquals(expected,actual);
    }

    @Test
    public void should_delete_tag_when_delete_given_tagId() {
        Tag tag1 = new Tag("tag1","blue");
        tag1.setId("1");

        tagService.delete("1");

        verify(tagRepository,times(1)).deleteById("1");
    }
}
