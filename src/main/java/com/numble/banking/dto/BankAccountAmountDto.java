package com.numble.banking.dto;

import com.numble.banking.domain.BankAccountAmount;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link BankAccountAmount} entity
 */
public record BankAccountAmountDto(Long id, Long accountId, String accountNumber, Long amount, LocalDateTime createAt, LocalDateTime updatedAt) {

    public static BankAccountAmountDto of (Long accountId, String accountNumber, Long amount) {
        return new BankAccountAmountDto(null, accountId, accountNumber, amount, null, null);
    }

    public static BankAccountAmount toEntity(BankAccountAmountDto bankAccountAmountDto) {
        return BankAccountAmount.of(bankAccountAmountDto.accountId, bankAccountAmountDto.accountNumber, bankAccountAmountDto.amount);
    }
}