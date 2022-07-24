package com.teamsfinder.userreadservice.tag.dto;

import com.teamsfinder.userreadservice.tag.model.Tag;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TagMapper {
    public static TagResponseDto mapTagToDto(Tag tag){
        return new TagResponseDto(tag.getId(), tag.getName());
    }
}
