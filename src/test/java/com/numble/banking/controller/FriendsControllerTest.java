package com.numble.banking.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.repository.ClientRepository;
import com.numble.banking.repository.FriendsRepository;
import com.numble.banking.service.ClientService;
import com.numble.banking.service.FriendsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Friends Controller Test")
@WebMvcTest(FriendsController.class)
class FriendsControllerTest {

    private final Logger LOGGER = LoggerFactory.getLogger(FriendsControllerTest.class);
    @Autowired
    private MockMvc mvc;

    @MockBean
    private FriendsService friendsService;
    
    @MockBean
    private ClientService clientService;

    @Autowired
    private ObjectMapper objectMapper;


    @DisplayName("내 친구 리스트 조회")
    @Test
    void givenClientId_whenRequestingFriendsList_thenReturnsFriendsList() throws Exception {
        ClientDto clientDto = ClientDto.of("thinkp92", "조동균", "1234", "abc@gmail.com");
        ClientDto clientDto2 = ClientDto.of("hyesoup", "오혜수", "1234", "abc@gmail.com");
        clientService.register(clientDto);
        clientService.register(clientDto2);
        friendsService.save("thinkp92", "hyesoup");


        String clientId = "thinkp92";

//        mvc.perform(get("/friends")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(toJson(clientDto)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
    }

    @DisplayName("친구 추가")
    @Test
    void givenClientIdAndFriendsClientId_whenInsertNewFriend_thenInsertNewFriend() throws Exception {
        String clientId        = "thinkp92";
        String friendsClientId = "hyesoup";

        mvc.perform(post("/friends")
                        .param("clientId", clientId)
                        .param("friendClientId", friendsClientId))
                .andDo(print())
                .andExpect(status().isOk());


    }

    private <T> String toJson(T data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }

}