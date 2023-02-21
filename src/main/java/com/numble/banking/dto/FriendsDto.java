package com.numble.banking.dto;

import com.numble.banking.domain.Friends;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.numble.banking.domain.Friends} entity
 */
public record FriendsDto(
        Long friendId,
        String clientId,
        String friendClientId,
        String friendName,
        String friendEmail,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public static FriendsDto of(
            Long friendId,
            String clientId,
            String friendClientId,
            String friendName,
            String friendEmail,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        return new FriendsDto(friendId, clientId, friendClientId, friendName, friendEmail, createdAt, updatedAt);
    }
    public static FriendsDto of(String clientId, String friendClientId, String friendName, String friendEmail) {
        return new FriendsDto(null, clientId, friendClientId, friendName, friendEmail, null, null);
    }

    public static FriendsDto toDto(Friends friends) {
        return FriendsDto.of(friends.getClientId(), friends.getFriendClientId(), friends.getFriendName(), friends.getFriendEmail());
    }

    public static Friends toEntity(FriendsDto friendsDto) {
        return new Friends(friendsDto.clientId, friendsDto.friendClientId, friendsDto.friendName, friendsDto.friendEmail);
    }

    public static Friends toEntity(String clientId, ClientDto clientDto) {
        return new Friends(clientId, clientDto.clientId(), clientDto.clientName(), clientDto.clientEmail());
    }
}