package com.numble.banking.domain;

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
    @Column(nullable = false, name = "friendId")
    private Long friendId;

    @Setter
    @Column(name = "clientId", nullable = false, unique = true)
    private String clientId;

    @Setter
    @Column(name = "friendClientId", nullable = false)
    private String friendClientId;

    @CreatedDate
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    protected Friends() {
    }

    public Friends(String clientId, String friendClientId) {
        this.clientId = clientId;
        this.friendClientId = friendClientId;
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
