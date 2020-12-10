package com.oocl.todoList.Controller;

import com.oocl.todoList.DTO.TagRequest;
import com.oocl.todoList.DTO.TagResponse;
import com.oocl.todoList.Mapper.TagMapper;
import com.oocl.todoList.Model.Tag;
import com.oocl.todoList.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tags")
@CrossOrigin
public class TagController {
    @Autowired
    private TagService tagService;
    @Autowired
    private TagMapper tagMapper;

    @GetMapping
    public List<TagResponse> getAll() {
        return tagService.getAll().stream().map(tagMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{tagId}")
    public TagResponse getById(@PathVariable String tagId) {
        return tagMapper.toResponse(tagService.getById(tagId));
    }

    @PostMapping
    public TagResponse create(@RequestBody TagRequest tagRequest) {
        Tag newTag = tagService.create(tagMapper.toEntity(tagRequest));
        return tagMapper.toResponse(newTag);
    }

    @PutMapping("/{tagId}")
    public TagResponse update(@PathVariable String tagId, @RequestBody TagRequest tagUpdate) {
        Tag tag = tagService.update(tagId, tagMapper.toEntity(tagUpdate));
        return tagMapper.toResponse(tag);
    }

    @DeleteMapping("/{tagId}")
    public void delete(@PathVariable String tagId) {
        tagService.delete(tagId);
    }

}
