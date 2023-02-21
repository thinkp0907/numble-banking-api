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

@DisplayName("JPA 연결 테스트")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @DisplayName("SELECT 테스트")
    @Test
    void given_When_Then() {
        // Given

        // When
//        List<Client> client = clientRepository.findAll();
        Client client = clientRepository.findClientByClientIdAndClientPassword("thinkp92", "ehdrbs92");
//        Optional<Client> client = clientRepository.findClientByClientIdAndClientPassword("thinkp92", "ehdrbs92");


        // Then
    }

    @DisplayName("정상적으로 아이디 및 비밀번호 입력시 Table 조회 후 존재하면 로그인")
    @Test
    void givenClientIdAndClientPassword_WhenPostingClientIdAnd_ThenInsertIntoClientTable() {
        // Given

        // When

        // Then
    }

    @DisplayName("정상적으로 아이디 및 비밀번호 입력시 로그인")
    @Test
    void givenRightClientIdAndClientPassword_WhenTryingToLogin_ThenLogin() {
        // Given

        // When

        // Then
    }

    @DisplayName("정상적인 ID, PW, 이름을 입력하면 회원가입 완료")
    @Test
    void givenClientIdAndClientPassword_WhenRetrievingClientId_ThenSuccess() {
        // Given

        // When

        // Then
    }



}