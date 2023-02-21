package com.numble.banking.dto;

import com.numble.banking.domain.BankAccount;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.numble.banking.domain.BankAccount} entity
 */
public record BankAccountDto(Long accountId, String clientId, String bankDiv, String bankName, String accountNumber) {

    public static BankAccountDto of (Long accountId, String clientId, String bankDiv, String bankName, String accountNumber) {
        return new BankAccountDto(accountId, clientId, bankDiv, bankName, accountNumber);
    }

    public static BankAccountDto toDto(BankAccount bankAccount) {
        return BankAccountDto.of(bankAccount.getAccountId(), bankAccount.getClientId(), bankAccount.getBankDiv(), bankAccount.getBankName(), bankAccount.getAccountNumber());
    }

    public static BankAccount toEntity(BankAccountDto bankAccountDto) {
        return BankAccount.of(bankAccountDto.clientId, bankAccountDto.bankDiv, bankAccountDto.bankName, bankAccountDto.accountNumber);
    }
}