package com.numble.banking.repository;

import com.numble.banking.domain.BankAccount;
import com.numble.banking.dto.BankAccountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    List<BankAccount> findBankAccountsByClientId(String clientId);

    BankAccount findBankAccountByClientIdAndBankDiv(String clientId, String bankDiv);

    BankAccount findBankAccountByBankDivAndAccountNumber(String bankDiv, String accountNumber);
}
