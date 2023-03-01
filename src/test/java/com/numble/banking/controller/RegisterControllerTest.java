package com.numble.banking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.service.ClientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("회원가입 API 테스트")
@WebMvcTest(RegisterController.class)
class RegisterControllerTest {

    @Autowired
    private RegisterController registerController;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ClientService clientService;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("이미 가입된 ID 이면 메시지를 뿌린다.")
    @Test
    void givenClientDto_whenRegisterWrongId_thenServiceReturnMessage() throws Exception {
        // Given
        ClientDto clientDto = ClientDto.of("thinkp92", "조동균", "ehdrbs92", "abc@naver.com");
        Map<String, String> input = new HashMap<>();
        // body에 json 형식으로 회원의 데이터를 넣기 위해서 Map을 이용한다.
        input.put("clientId", "thinkp92");
        input.put("clientName", "조동균");
        input.put("clientPassword", "ehdrbs92");
        input.put("clientEmail", "abc@naver.com");


        // When
        when(clientService.register(clientDto)).thenReturn(clientDto);
        // Then
        mvc.perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk()).andReturn();

//                .andExpect(MockMvcResultMatchers.content().string(contains("이미 존재하는 ID 입니다.")));
    }
}