package com.teamsfinder.userreadservice.user.service;

import com.teamsfinder.userreadservice.user.dto.UserDto;

import java.security.Principal;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
}
