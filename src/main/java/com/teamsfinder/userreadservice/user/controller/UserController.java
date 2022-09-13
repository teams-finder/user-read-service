package com.teamsfinder.userreadservice.user.controller;

import com.teamsfinder.userreadservice.user.dto.UserResponseDto;
import com.teamsfinder.userreadservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/read/users")
@RequiredArgsConstructor
class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    UserResponseDto getUserById(@PathVariable("id") Long id) {

        return userService.getUserById(id);
    }

    @GetMapping("/kc/{keycloakId}")
    UserResponseDto getUserByKeycloakId(@PathVariable("keycloakId") String keycloakId) {

        return userService.getUserByKeyCloakId(keycloakId);
    }
    
    @GetMapping
    List<UserResponseDto> getUserByUsername(@RequestParam("username") String username) {

        return userService.getUsersByUsername(username);
    }
}
