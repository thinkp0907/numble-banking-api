package com.numble.banking.domain;

import com.numble.banking.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@NoArgsConstructor
@Entity
@Table(name = "friends")
@Getter
@ToString
public class Friends extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "friend_Id")
    private Long friendId;

    @Setter
    @Column(name = "client_Id", nullable = false, unique = true)
    private String clientId;

    @Setter
    @Column(name = "friend_Client_Id", nullable = false)
    private String friendClientId;

    @Setter
    @Column(name = "friend_Name")
    private String friendName;

    @Setter
    @Column(name = "friend_Email")
    private String friendEmail;


    public Friends(String clientId, String friendClientId, String friendName, String friendEmail) {
        this.clientId = clientId;
        this.friendClientId = friendClientId;
        this.friendName = friendName;
        this.friendEmail = friendEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Friends friends)) return false;
        return friendId.equals(friends.friendId) && clientId.equals(friends.clientId) && friendClientId.equals(friends.friendClientId) && friendName.equals(friends.friendName) && friendEmail.equals(friends.friendEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendId, clientId, friendClientId, friendName, friendEmail);
    }
}
