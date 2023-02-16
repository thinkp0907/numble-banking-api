package com.numble.banking.dto;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.numble.banking.domain.Friends} entity
 */
public record FriendsDto(Long friendId, String clientId, String friendClientId, LocalDateTime createdAt,
                         LocalDateTime updatedAt) {

    public static FriendsDto of(String clientId, String friendClientId) {
        return new FriendsDto(null, clientId, friendClientId, null, null);
    }

}