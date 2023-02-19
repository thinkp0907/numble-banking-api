package com.numble.banking.dto;

import com.numble.banking.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public record ClientDto(Long id, String clientId, String clientName, String clientPassword, LocalDateTime createdAt, LocalDateTime updatedAt) {

    public static ClientDto of(String clientId, String clientName, String clientPassword) {
        return new ClientDto(null, clientId, clientName, clientPassword, null, null);
    }

    public static ClientDto of(Long id, String clientId, String clientName, String clientPassword, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ClientDto(id, clientId, clientName, clientPassword, createdAt, updatedAt);
    }

}
