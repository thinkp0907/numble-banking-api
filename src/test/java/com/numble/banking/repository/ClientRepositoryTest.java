package com.numble.banking.repository;

import com.numble.banking.domain.Client;
import com.numble.banking.dto.ClientDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @DisplayName("등록된 ID, 비밀번호 입력시 정상적으로 조회")
    @Test
    void givenCorrectIdAndPassword_WhenLogin_ThenSuccessfullyRetrieve() {
        // Given
        String id = "thinkp92";
        String pw = "ehdrbs92";
        // When
        Client client = clientRepository.findClientByClientIdAndClientPassword(id, pw);
        // Then
        assertNotEquals(client, null);
        assertEquals(client.getClientId(), "thinkp92");
        assertEquals(client.getClientPassword(), "ehdrbs92");
    }

    @DisplayName("등록되지 않은 ID, 비밀번호 입력시 null")
    @Test
    void givenWrongIdAndPassword_WhenLogin_ThenFailToRetrieve() {
        // Given
        String id = "tdjsalk";
        String pw = "sdlakjf";
        // When
        Client client = clientRepository.findClientByClientIdAndClientPassword(id, pw);
        // Then
        assertNull(client);
    }

    @DisplayName("정상적인 ID, PW, 이름을 입력하면 회원가입 완료")
    @Test
    void givenClientInfo_whenRegister_thenSuccessfullyRegister() {
        // Given
        ClientDto clientDto = ClientDto.of("abc", "abc", "abc", "abc@gamil.com");
        // When
        Client client = clientRepository.save(ClientDto.toEntity(clientDto));
        // Then
        assertEquals(clientDto.clientName(), client.getClientName());
        assertEquals(clientDto.clientEmail(), client.getClientEmail());
        assertEquals(clientDto.clientPassword(), client.getClientPassword());
        assertEquals(clientDto.clientId(), client.getClientId());
    }



}