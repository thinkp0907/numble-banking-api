package com.numble.banking.repository;

import com.numble.banking.domain.Friends;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Friends Repository Test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class FriendsRepositoryTest {


    @Autowired
    private FriendsRepository friendsRepository;

    @DisplayName("내 아이디로 친구 List 조회")
    @Test
    void givenClientId_whenRequestingFriendsList_thenReturnsFriendsList() throws Exception {
        // Given
        String clientId = "thinkp92";
        // When
        List<Friends> friends =  friendsRepository.findFriendsByClientId(clientId);
        // Then
        assertFalse(friends.isEmpty());
        assertEquals(friends.size(), 2);
    }
}