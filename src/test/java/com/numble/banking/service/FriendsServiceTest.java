package com.numble.banking.service;

import com.numble.banking.domain.Client;
import com.numble.banking.domain.Friends;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.dto.FriendsDto;
import com.numble.banking.repository.ClientRepository;
import com.numble.banking.repository.FriendsRepository;
import jakarta.persistence.MapKeyColumn;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class FriendsServiceTest {

    private final Logger LOGGER = LoggerFactory.getLogger(FriendsServiceTest.class);

    @InjectMocks
    private FriendsService friendsService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private FriendsRepository friendsRepository;

    @DisplayName("내 친구 목록 조회")
    @Test
    void givenClientId_whenRetrieveFriends_thenReturnFriends() throws Exception{
        // Given
        String clientId = "thinkp92";

        List<Friends> friendsList = friendsService.findFriends(clientId).stream().map(FriendsDto::toEntity).toList();
        // When
        Assertions.assertThat(friendsRepository.findFriendsByClientId("thinkp92"))
                .isEqualTo(friendsList);
        // Then

    }

    @DisplayName("Client 가 아닌 친구 등록 시 null")
    @Test
    void givenClientIdAndFriendClientId_whenRegisterFriend_thenRegisterFail()  throws Exception{
        // Given
        String clientId = "thinkp92";
        String friendClientId = "hyesoup";
        // When
        ClientDto friendsDto = friendsService.save(clientId, friendClientId);

        // Then
        Assertions.assertThat(friendsDto).isNull();
    }

}