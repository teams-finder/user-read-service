package com.teamsfinder.userreadservice.user.controller;

import com.teamsfinder.userreadservice.user.dto.UserDto;
import com.teamsfinder.userreadservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class UserController {
    private final UserService userService;

    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/id")
    ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
