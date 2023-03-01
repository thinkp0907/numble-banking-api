package com.numble.banking.dto;

public record BankAccountUpdateDto(String clientId, String bankDiv, String bankName, String accountNumber, Long amount) {

}
