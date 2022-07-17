package com.teamsfinder.userreadservice.tag.dto;

import com.teamsfinder.userreadservice.tag.model.Tag;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TagMapper {
    public static TagDto mapToDto(Tag tag){
        return new TagDto(tag.getId(), tag.getName());
    }

    public static Tag mapFromDto(TagDto tagDto){
        return Tag.builder()
                .id(tagDto.id())
                .name(tagDto.name())
                .build();
    }
}
