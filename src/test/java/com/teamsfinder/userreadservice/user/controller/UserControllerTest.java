package com.teamsfinder.userreadservice.user.controller;

import com.teamsfinder.userreadservice.user.IntegrationBaseClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest extends IntegrationBaseClass {

    private static final String GET_ALL_END_POINT = "/users";
    private static final String FIRST_USER_ID_JSON_PATH = "$.[0].id";
    private static final String GET_USER_END_POINT = "/users/1";
    private static final String ID_JSON_PATH = "$.id";
    private static final String BLOCKED_JSON_PATH = "$.blocked";
    private static final String KEYCLOAK_ID_JSON_PATH = "$.keyCloakId";
    private static final String ACCOUNT_TYPE_JSON_PATH = "$.accountType";
    private static final String GITHUB_JSON_PATH = "$.githubProfileUrl";
    private static final String PICTURE_JSON_PATH = "$.profilePictureUrl";
    private static final String TAGS_JSON_PATH = "$.tags";
    private static final String KEYCLOAK_ID_VALUE = "testId";
    private static final String ACCOUNT_TYPE_VALUE = "USER";
    private static final String GITHUB_VALUE = "GITHUB";
    private static final String PICTURE_VALUE = "PICTURE";

    @Test
    void shouldGetAllUsers() throws Exception {
        //given
        //when
        ResultActions performRequest = mockMvc.perform(get(GET_ALL_END_POINT));
        //then
        performRequest
                .andExpect(status().isOk())
                .andExpect(jsonPath(FIRST_USER_ID_JSON_PATH).value(1L));
    }

    @Test
    void shouldGetUserById() throws Exception {
        //given
        //when
        ResultActions performRequest =  mockMvc.perform(get(GET_USER_END_POINT));
        //then
        performRequest
                .andExpect(status().isOk())
                .andExpect(jsonPath(ID_JSON_PATH).value(1L))
                .andExpect(jsonPath(KEYCLOAK_ID_JSON_PATH).value(KEYCLOAK_ID_VALUE))
                .andExpect(jsonPath(ACCOUNT_TYPE_JSON_PATH).value(ACCOUNT_TYPE_VALUE))
                .andExpect(jsonPath(GITHUB_JSON_PATH).value(GITHUB_VALUE))
                .andExpect(jsonPath(PICTURE_JSON_PATH).value(PICTURE_VALUE))
                .andExpect(jsonPath(TAGS_JSON_PATH).exists())
                .andExpect(jsonPath(BLOCKED_JSON_PATH).value(false));
    }
}