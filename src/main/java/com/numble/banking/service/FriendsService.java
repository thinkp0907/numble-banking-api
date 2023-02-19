package com.numble.banking.service;

import com.numble.banking.domain.Friends;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.dto.FriendsDto;
import com.numble.banking.repository.ClientRepository;
import com.numble.banking.repository.FriendsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Transactional
@Service
public class FriendsService {

    private final FriendsRepository friendsRepository;

    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<FriendsDto> findFriends(String clientId) throws Exception{

        List<Friends> friends = friendsRepository.findFriendsByClientId(clientId);

        return friends.stream()
                .map(friend -> friend.toDto(friend))
                .toList();

    }

    public ClientDto save(String clientId, String friendClientId) {
        // TODO: 친구 ID가 client 테이블에 있어야지만 등록 할 수 있게 만들어야함.
        ClientDto clientDto = clientRepository.findClientByClientId(friendClientId);

        if(!Objects.isNull(clientDto)) {
            FriendsDto friendsDto = FriendsDto.of(clientId, friendClientId);
            friendsRepository.save(friendsDto);
        }

        return clientDto;

    }
}
