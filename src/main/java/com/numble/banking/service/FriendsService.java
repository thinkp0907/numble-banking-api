package com.numble.banking.service;

import com.numble.banking.domain.Client;
import com.numble.banking.domain.Friends;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.dto.FriendsDto;
import com.numble.banking.repository.ClientRepository;
import com.numble.banking.repository.FriendsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Transactional
@Service
public class FriendsService {

    private final FriendsRepository friendsRepository;

    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<FriendsDto> findFriends(String clientId) {

        List<Friends> friends = friendsRepository.findFriendsByClientId(clientId);

        return friends.stream()
                .map(friend -> FriendsDto.of(friend.getClientId(), friend.getFriendClientId(), friend.getFriendName(), friend.getFriendEmail()))
                .toList();

    }


    public ClientDto save(String clientId, String friendClientId) {
        ClientDto clientDto = null;

        Client client = clientRepository.findClientByClientId(friendClientId);

        if(client != null)  {
            clientDto = ClientDto.toDto(client);
        }


        if(clientDto != null) {
            Friends friends = FriendsDto.toEntity(clientId, clientDto);
            friendsRepository.save(friends);
        }

        return clientDto;

    }
}
