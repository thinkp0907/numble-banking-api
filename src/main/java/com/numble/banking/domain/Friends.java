package com.numble.banking.domain;

import com.numble.banking.dto.FriendsDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@EqualsAndHashCode
@NoArgsConstructor
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

    public Friends(String clientId, String friendClientId) {
        this.clientId = clientId;
        this.friendClientId = friendClientId;
    }

    public FriendsDto toDto(Friends friends) {
        return new FriendsDto(friends.friendId ,friends.clientId, friends.friendClientId, friends.createdAt, friends.updatedAt);
    }

}
