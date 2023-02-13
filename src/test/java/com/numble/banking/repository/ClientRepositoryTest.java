package com.numble.banking.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @DisplayName("아무것도 입력안하고 로그인 시도 시, Do nothing ?")
    @Test
    void givenNothing_WhenRetrievingMyAccount_ThenReturnsError() {
        // Given

        // When

        // Then
    }

    @DisplayName("정상적으로 아이디 및 비밀번호 입력시 Table 조회 후 존재안하면 로그인 X")
    @Test
    void givenClientIdAndClientPassword_WhenPostingClientIdAndIfExists_ThenLoginErrorMessage() {
        // Given

        // When

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
    void givenClientIdAndClientPassword_WhenRetrievingClientId_ThenReturnsSuccess() {
        // Given

        // When

        // Then
    }

    @DisplayName("정상적으로 아이디 및 비밀번호 입력시 로그인")
    @Test
    void givenClientIdAndClientPassword_WhenRetrievingClientId_ThenSuccess() {
        // Given

        // When

        // Then
    }
}