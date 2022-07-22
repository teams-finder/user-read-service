package com.teamsfinder.userreadservice.user.service;

import com.teamsfinder.userreadservice.user.dto.UserDto;
import com.teamsfinder.userreadservice.user.model.AccountType;
import com.teamsfinder.userreadservice.user.model.User;
import com.teamsfinder.userreadservice.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {
    private static final String USER_KEYCLOAK_ID = "KEYCLOAK_ID";
    private static final String USER_GITHUB = "GITHUB";
    private static final String USER_PICTURE = "PICTURE";

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userService;

    private User testUser = User.builder()
            .id(1L)
            .keyCloakId(USER_KEYCLOAK_ID)
            .accountType(AccountType.USER)
            .githubProfileUrl(USER_GITHUB)
            .profilePictureUrl(USER_PICTURE)
            .blocked(false)
            .tags(new ArrayList<>())
            .build();

    @Test
    void getAllUsers() {
        //given
        //when
        Mockito.when(userRepository.findAll()).thenReturn(List.of(testUser));
        //then
        List<UserDto> usersDtos = userService.getAllUsers();
        UserDto userDto = usersDtos.get(0);
        assertThat(userDto.id()).isEqualTo(1L);
        assertThat(userDto.keyCloakId()).isEqualTo(USER_KEYCLOAK_ID);
        assertThat(userDto.accountType()).isEqualTo(AccountType.USER.toString());
        assertThat(userDto.githubProfileUrl()).isEqualTo(USER_GITHUB);
        assertThat(userDto.profilePictureUrl()).isEqualTo(USER_PICTURE);
        assertThat(userDto.blocked()).isEqualTo(false);
        assertThat(userDto.tags().size()).isEqualTo(0);
    }

    @Test
    void getUserById() {
        //given
        //when
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(testUser));
        //then
        UserDto userDto = userService.getUserById(1L);
        assertThat(userDto.id()).isEqualTo(1L);
        assertThat(userDto.keyCloakId()).isEqualTo(USER_KEYCLOAK_ID);
        assertThat(userDto.accountType()).isEqualTo(AccountType.USER.toString());
        assertThat(userDto.githubProfileUrl()).isEqualTo(USER_GITHUB);
        assertThat(userDto.profilePictureUrl()).isEqualTo(USER_PICTURE);
        assertThat(userDto.blocked()).isEqualTo(false);
        assertThat(userDto.tags().size()).isEqualTo(0);
    }
}