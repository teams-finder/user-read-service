package com.teamsfinder.userreadservice.tag.dto;

import com.teamsfinder.userreadservice.tag.model.Tag;

public abstract class TagMapper {
    static TagDto mapToDto(Tag tag){
        return new TagDto(tag.getId(), tag.getName());
    }

    static Tag mapFromDto(TagDto tagDto){
        return Tag.builder()
                .id(tagDto.id())
                .name(tagDto.name())
                .build();
    }
}
