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

    @Test
    void shouldGetAllUsers() throws Exception {
        //given
        //when
        ResultActions resultActions = mockMvc.perform(get("/users"));
        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(1L));
    }

    @Test
    void shouldGetUserById() throws Exception {
        //given
        //when
        ResultActions resultActions =  mockMvc.perform(get("/users/1"));
        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.keyCloakId").value("testId"))
                .andExpect(jsonPath("$.accountType").value("USER"))
                .andExpect(jsonPath("$.githubProfileUrl").value("GITHUB"))
                .andExpect(jsonPath("$.profilePictureUrl").value("PICTURE"))
                .andExpect(jsonPath("$.tags").exists())
                .andExpect(jsonPath("$.blocked").value(false));
    }
}