package com.oocl.todoList.Service;

import com.oocl.todoList.Model.Tag;
import com.oocl.todoList.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public Tag getById(String tagId) {
        return null;
    }
}
