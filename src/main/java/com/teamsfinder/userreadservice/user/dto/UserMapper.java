package com.teamsfinder.userreadservice.user.dto;

import com.teamsfinder.userreadservice.tag.dto.TagDto;
import com.teamsfinder.userreadservice.tag.dto.TagMapper;
import com.teamsfinder.userreadservice.tag.model.Tag;
import com.teamsfinder.userreadservice.user.model.AccountType;
import com.teamsfinder.userreadservice.user.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class UserMapper {
    public static UserDto mapToDto(User user){
        AccountType accountType = user.getAccountType();
        return new UserDto(user.getId(), user.getKeyCloakId(), accountType.toString(), user.getGithubProfileUrl(), user.getProfilePictureUrl(), user.isBlocked(), mapTagsToDto(user.getTags()));
    }

    private static List<TagDto> mapTagsToDto(List<Tag> tags) {
        return tags.stream()
                .map(TagMapper::mapToDto)
                .toList();
    }
}