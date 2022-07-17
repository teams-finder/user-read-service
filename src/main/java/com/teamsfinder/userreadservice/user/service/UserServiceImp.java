package com.teamsfinder.userreadservice.user.service;

import com.teamsfinder.userreadservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserServiceImp {
    private final UserRepository userRepository;
}
