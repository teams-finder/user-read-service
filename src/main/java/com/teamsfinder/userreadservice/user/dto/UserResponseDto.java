package com.teamsfinder.userreadservice.user.dto;

import com.teamsfinder.userreadservice.tag.dto.TagResponseDto;
import com.teamsfinder.userreadservice.user.model.AccountType;

import java.util.List;

public record UserResponseDto(
        Long id,
        String keyCloakId,
        AccountType accountType,
        String githubProfileUrl,
        String profilePictureUrl,
        boolean blocked,
        List<TagResponseDto> tags
) {

}
