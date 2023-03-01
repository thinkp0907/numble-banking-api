package com.numble.banking.service;

import com.numble.banking.dto.ClientDto;
import com.numble.banking.repository.ClientRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @DisplayName("신규 회원가입시 정상동작")
    @Test
    void givenNewClientDto_whenRegister_thenSuccessfullyRegister() {
        // Given
        ClientDto clientDto = ClientDto.of("abc", "abc", "abc", "abc@gamil.com");
        // When
        when(clientRepository.save(any())).thenReturn(ClientDto.toEntity(clientDto));
        ClientDto returnClient = clientService.register(clientDto);
        // Then
        assertEquals(returnClient, clientDto);
    }

    @Disabled
    @DisplayName("이미 등록된 ID 일 경우 회원가입 실패")
    @Test
    void givenExistingClientDto_whenRegister_thenRegisterFail() {
        // Given
        ClientDto clientDto = ClientDto.of("thinkp92", "chorlcok", "1234", "abc@gamil.com");
        // When
        ClientDto returnClient = clientService.register(clientDto);
        assertEquals(returnClient, clientDto);

        ClientDto returnClient2 = clientService.register(clientDto);
        // Then
        assertNull(returnClient2);
    }
}