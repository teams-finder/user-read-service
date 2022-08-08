package com.teamsfinder.userreadservice.tag.dto;

import com.teamsfinder.userreadservice.tag.model.Tag;

public record TagResponseDto(

        Long id,

        String name
) {

    public TagResponseDto(Tag tag){
        this(
                tag.getId(),
                tag.getName()
        );
    }
}
