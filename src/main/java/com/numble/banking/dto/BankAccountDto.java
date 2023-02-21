package com.numble.banking.dto;


import com.numble.banking.domain.BankAccount;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.numble.banking.domain.BankAccount} entity
 */
public record BankAccountDto(Long accountId, String clientId, String bankDiv, String bankName, String accountNumber,
                             LocalDateTime createAt, LocalDateTime updatedAt) {

    public static BankAccountDto of (Long accountId, String clientId, String bankDiv, String bankName, String accountNumber,
                                     LocalDateTime createAt, LocalDateTime updatedAt) {
        return new BankAccountDto(accountId, clientId, bankDiv, bankName, accountNumber, createAt, updatedAt);
    }

    public static BankAccount toEntity(BankAccountDto bankAccountDto) {
        return BankAccount.of(bankAccountDto.clientId, bankAccountDto.bankDiv, bankAccountDto.bankName, bankAccountDto.accountNumber);
    }

}