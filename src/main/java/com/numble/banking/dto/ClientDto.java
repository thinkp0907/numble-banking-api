package com.numble.banking.dto;

import com.numble.banking.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public record ClientDto(
        String clientId,
        String clientName,
        String clientPassword,
        String clientEmail) {


    public static ClientDto of(String clientId, String clientName, String clientPassword, String clientEmail) {
        return new ClientDto(clientId, clientName, clientPassword, clientEmail);
    }

    public static Client toEntity(ClientDto clientDto) {
        return Client.of(clientDto.clientId, clientDto.clientName, clientDto.clientPassword, clientDto.clientEmail);
    }

    public static ClientDto toDto(Client client) {
        return ClientDto.of(client.getClientId(), client.getClientName(), client.getClientPassword(), client.getClientEmail());
    }
}
