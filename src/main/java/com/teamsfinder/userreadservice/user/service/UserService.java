package com.teamsfinder.userreadservice.user.service;

import com.teamsfinder.userreadservice.tag.dto.TagResponseDto;
import com.teamsfinder.userreadservice.tag.model.Tag;
import com.teamsfinder.userreadservice.user.dto.UserResponseDto;
import com.teamsfinder.userreadservice.user.exception.UserNotFoundException;
import com.teamsfinder.userreadservice.user.model.AccountType;
import com.teamsfinder.userreadservice.user.model.User;
import com.teamsfinder.userreadservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponseDto> getAllUsers() {
        List<User> users = getAllFromRepository();
        return mapUsersToDto(users);
    }

    private List<UserResponseDto> mapUsersToDto(List<User> users) {
        return users.stream()
                .map(this::mapUserToDto)
                .toList();
    }

    private List<User> getAllFromRepository() {
        return userRepository.findAll();
    }

    public UserResponseDto getUserById(Long id) {
        User user = getUserFromRepository(id);
        return mapUserToDto(user);
    }

    private UserResponseDto mapUserToDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getKeyCloakId(),
                user.getAccountType(),
                user.getGithubProfileUrl(),
                user.getProfilePictureUrl(),
                user.isBlocked(),
                mapTagsToDto(user.getTags())
        );
    }

    private List<TagResponseDto> mapTagsToDto(List<Tag> tags) {
        return tags.stream()
                .map(tag -> mapTagToDto(tag))
                .toList();
    }

    private TagResponseDto mapTagToDto(Tag tag) {
        return new TagResponseDto(
                tag.getId(),
                tag.getName()
        );
    }

    private User getUserFromRepository(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
