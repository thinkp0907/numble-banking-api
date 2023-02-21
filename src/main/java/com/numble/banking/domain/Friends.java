package com.numble.banking.domain;


import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "friends")
@Getter
@ToString
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "friend_Id")
    private Long friendId;

    @Setter
    @Column(name = "client_Id", nullable = false, unique = true)
    private String clientId;

    @Setter
    @Column(name = "friend_ClientId", nullable = false)
    private String friendClientId;

    @CreatedDate
    @Column(name = "created_At")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_At")
    private LocalDateTime updatedAt;


    protected Friends() {
    }

    public Friends(String clientId, String friendClientId) {
        this.clientId = clientId;
        this.friendClientId = friendClientId;
    }


    public FriendsDto toDto(Friends friends) {
        return new FriendsDto(friends.friendId ,friends.clientId, friends.friendClientId, friends.createdAt, friends.updatedAt);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Friends friends)) return false;
        return friendId == friends.friendId && clientId.equals(friends.clientId) && friendClientId.equals(friends.friendClientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendId, clientId, friendClientId);
    }

}
