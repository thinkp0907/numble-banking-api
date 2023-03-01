package com.numble.banking.repository;

import com.numble.banking.domain.Client;
import com.numble.banking.domain.Friends;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.dto.FriendsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.internal.matchers.text.ValuePrinter.print;

@DisplayName("Friends Repository Test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class FriendsRepositoryTest {

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private ClientRepository clientRepository;

    @DisplayName("내 친구 목록 조회")
    @Test
    void givenClientId_whenRequestingFriendsList_thenReturnsFriendsList() throws Exception {
        // Given

        String clientId = "thinkp92";
        // When
        List<Friends> friends =  friendsRepository.findFriendsByClientId(clientId);
        // Then
        assertFalse(friends.isEmpty());
        assertEquals(friends.size(), 2);

        friends.forEach(friends1 -> System.out.println(friends1.toString()));
    }


    @DisplayName("친구 추가 하기")
    @Test
    public void givenMyClientIdAndFriendClientId_whenRegisteringFriend_thenSuccessfullyRegister() {
        // Given
        String myClientId = "thinkp92";
        String friendClientId = "hyesoup";
        // When
        Client client = clientRepository.findClientByClientId(friendClientId);

        FriendsDto friendsDto = FriendsDto.of(myClientId, client.getClientId(), client.getClientName(), client.getClientEmail());
        Friends friends = friendsRepository.save(FriendsDto.toEntity(friendsDto));
        // Then
        assertEquals(friends.getClientId(), myClientId);
        assertEquals(friends.getFriendClientId(), friendClientId);
    }
}