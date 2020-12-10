package com.oocl.todoList.Mapper;

import com.oocl.todoList.DTO.TagRequest;
import com.oocl.todoList.DTO.TagResponse;
import com.oocl.todoList.Model.Tag;
import com.oocl.todoList.Service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {
    public Tag toEntity(TagRequest tagRequest) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(tagRequest,tag);
        return tag;
    }

    public TagResponse toResponse(Tag tag) {
        TagResponse tagResponse = new TagResponse();
        BeanUtils.copyProperties(tag,tagResponse);
        return tagResponse;
    }
}
