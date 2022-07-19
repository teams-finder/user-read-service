package com.teamsfinder.userreadservice.user.service;

import com.teamsfinder.userreadservice.user.dto.UserDto;
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
    public List<UserDto> getAllUsers() {
        List<User> users = getAll();
        return mapUsersToDto(users);
    }

    private List<UserDto> mapUsersToDto(List<User> users) {
        return users.stream()
                .map(UserMapper::mapToDto)
                .toList();
    }

    private List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = getUser(id);
        return mapUserToDto(user);
    }

    private UserDto mapUserToDto(User user) {
        return UserMapper.mapToDto(user);
    }

    private User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
