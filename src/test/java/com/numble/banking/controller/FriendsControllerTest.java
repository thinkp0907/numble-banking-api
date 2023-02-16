package com.numble.banking.controller;

import com.numble.banking.service.FriendsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Friends Controller Test")
@AutoConfigureMockMvc
@SpringBootTest(

)
class FriendsControllerTest {

    private static MockMvc mvc;

    @Autowired
    private FriendsController controller;

    @Autowired
    @MockBean private FriendsService service;
    // Control 과 Service 의 기능을 함께 테스트 하기위해 SpringBootTest 사용.
    @DisplayName("내 친구 리스트 조회")
    @Test
    void givenClientId_whenRequestingFriendsList_thenReturnsFriendsList() throws Exception {
        String clientId = "thinkp92";

        assertNotNull(controller.findFriends(clientId));
        assertEquals(service.findFriends(clientId), controller.findFriends(clientId));
    }

    @DisplayName("친구 추가")
    @Test
    void givenClientIdAndFriendsClientId_whenInsertNewFriend_thenInsertNewFriend() throws Exception {
        String clientId        = "thinkp92";
        String friendsClientId = "hyesoup";

        controller.registerFriend(clientId, friendsClientId);

    }


}