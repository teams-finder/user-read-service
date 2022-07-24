package com.teamsfinder.userreadservice.user.service;

import com.teamsfinder.userreadservice.user.dto.UserResponseDto;
import com.teamsfinder.userreadservice.user.dto.UserMapper;
import com.teamsfinder.userreadservice.user.exception.UserNotFoundException;
import com.teamsfinder.userreadservice.user.model.User;
import com.teamsfinder.userreadservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = getAllFromRepository();
        return mapUsersToDto(users);
    }

    private List<UserResponseDto> mapUsersToDto(List<User> users) {
        return users.stream()
                .map(UserMapper::mapUserToDto)
                .toList();
    }

    private List<User> getAllFromRepository() {
        return userRepository.findAll();
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = getUserFromRepository(id);
        return UserMapper.mapUserToDto(user);
    }

    private User getUserFromRepository(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
