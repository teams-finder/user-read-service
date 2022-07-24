package com.teamsfinder.userreadservice.user.dto;

import com.teamsfinder.userreadservice.tag.dto.TagResponseDto;
import com.teamsfinder.userreadservice.tag.dto.TagMapper;
import com.teamsfinder.userreadservice.tag.model.Tag;
import com.teamsfinder.userreadservice.user.model.AccountType;
import com.teamsfinder.userreadservice.user.model.User;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class UserMapper {

    public static UserResponseDto mapUserToDto(User user){
        AccountType accountType = user.getAccountType();
        return new UserResponseDto(user.getId(), user.getKeyCloakId(), accountType.toString(), user.getGithubProfileUrl(), user.getProfilePictureUrl(), user.isBlocked(), mapTagsToDto(user.getTags()));
    }

    private static List<TagResponseDto> mapTagsToDto(List<Tag> tags) {
        return tags.stream()
                .map(TagMapper::mapTagToDto)
                .toList();
    }
}
