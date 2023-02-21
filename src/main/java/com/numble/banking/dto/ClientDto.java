package com.numble.banking.dto;

import com.numble.banking.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public record ClientDto(
        Long id,
        String clientId,
        String clientName,
        String clientPassword,
        String clientEmail,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {


    public static ClientDto of(Long id, String clientId, String clientName, String clientPassword, String clientEmail, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ClientDto(id, clientId, clientName, clientPassword, clientEmail, createdAt, updatedAt);
    }

    public static ClientDto of(String clientId, String clientName, String clientPassword, String clientEmail) {
        return new ClientDto(null, clientId, clientName, clientPassword, clientEmail, null, null);
    }


    public static Client toEntity(ClientDto clientDto) {
        return Client.of(clientDto.clientId, clientDto.clientName, clientDto.clientPassword, clientDto.clientEmail);
    }

}
