package com.teamsfinder.userreadservice.user.dto;

import com.teamsfinder.userreadservice.tag.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public record UserDto (Long id, UUID keyCloakId, String accountType, String githubProfileUrl, String profilePictureUrl, boolean blocked, List<TagDto> tags){ }
