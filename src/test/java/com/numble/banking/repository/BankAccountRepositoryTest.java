package com.numble.banking.repository;

import com.numble.banking.domain.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bank Account Repository Test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class BankAccountRepositoryTest {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @DisplayName("내 아이디로 계좌 조회시, 내 계좌 리스트 반환")
    @Test
    void givenClientId_WhenRequestingBankAccounts_ThenReturnsBankAccountsList() throws Exception {
        // Given
        String clientId = "thinkp92";
        // When
        List<BankAccount> bankAccountList = bankAccountRepository.findBankAccountsByClientId(clientId);
        // Then

        assertFalse(bankAccountList.isEmpty());
        assertNotNull(bankAccountList);

        bankAccountList.forEach(bankAccount -> assertEquals(bankAccount.getClientId(), clientId));

    }
}