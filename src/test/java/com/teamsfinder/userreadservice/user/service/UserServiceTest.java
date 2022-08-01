package com.teamsfinder.userreadservice.user.service;

import com.teamsfinder.userreadservice.user.UnitBaseClass;
import com.teamsfinder.userreadservice.user.dto.UserResponseDto;
import com.teamsfinder.userreadservice.user.model.AccountType;
import com.teamsfinder.userreadservice.user.model.User;
import com.teamsfinder.userreadservice.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class UserServiceTest extends UnitBaseClass {

    private static final String USER_KEYCLOAK_ID = "KEYCLOAK_ID";
    private static final String USER_GITHUB = "GITHUB";
    private static final String USER_PICTURE = "PICTURE";

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService underTest;

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
        when(userRepository.findAll()).thenReturn(List.of(testUser));

        //when
        List<UserResponseDto> usersDtos = underTest.getAllUsers();

        //then
        assertThat(usersDtos).isNotEmpty();
        UserResponseDto userDto = usersDtos.get(0);
        assertThat(userDto.id()).isEqualTo(1L);
        assertThat(userDto.keyCloakId()).isEqualTo(USER_KEYCLOAK_ID);
        assertThat(userDto.accountType()).isEqualTo(AccountType.USER);
        assertThat(userDto.githubProfileUrl()).isEqualTo(USER_GITHUB);
        assertThat(userDto.profilePictureUrl()).isEqualTo(USER_PICTURE);
        assertThat(userDto.blocked()).isEqualTo(false);
        assertThat(userDto.tags().size()).isEqualTo(0);
    }

    @Test
    void getUserById() {
        //given
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(testUser));

        //when
        UserResponseDto userDto = underTest.getUserById(1L);

        //then
        assertThat(userDto.id()).isEqualTo(1L);
        assertThat(userDto.keyCloakId()).isEqualTo(USER_KEYCLOAK_ID);
        assertThat(userDto.accountType()).isEqualTo(AccountType.USER);
        assertThat(userDto.githubProfileUrl()).isEqualTo(USER_GITHUB);
        assertThat(userDto.profilePictureUrl()).isEqualTo(USER_PICTURE);
        assertThat(userDto.blocked()).isEqualTo(false);
        assertThat(userDto.tags().size()).isEqualTo(0);
    }
}