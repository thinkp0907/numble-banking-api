package com.numble.banking.controller;

import com.numble.banking.domain.Friends;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.dto.FriendsDto;
import com.numble.banking.service.ClientService;
import com.numble.banking.service.FriendsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/friends")
public class FriendsController {

    private final Logger LOGGER = LoggerFactory.getLogger(FriendsController.class);

    private final FriendsService friendsService;


    @GetMapping("/")
    public ResponseEntity<List<FriendsDto>> findFriends(@RequestBody ClientDto clientDto) {
        List<FriendsDto> FriendsDto = friendsService.findFriends(clientDto.clientId());
        FriendsDto.forEach(friendsDto -> LOGGER.info(friendsDto.toString()));

        if(friendsService.findFriends(clientDto.clientId()).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(friendsService.findFriends(clientDto.clientId()));
    }

    @PostMapping("/friends")
    public ResponseEntity<String> registerFriend(@RequestParam String clientId, String friendClientId) {
        String message = "";

        ClientDto clientDto = friendsService.save(clientId, friendClientId);

        if(Objects.isNull(clientDto)) {
            message = "해당 친구 ID는 존재하지 않는 ID 입니다.";
        } else {
            message = "성공적으로 등록되었습니다.";
        }
        return ResponseEntity.ok(message);
    }
}
