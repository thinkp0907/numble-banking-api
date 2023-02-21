package com.numble.banking.controller;

import com.numble.banking.domain.Friends;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.dto.FriendsDto;
import com.numble.banking.service.FriendsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/friends")
public class FriendsController {

    private final FriendsService friendsService;


    @GetMapping("/{clientId}")
    public ResponseEntity<List<FriendsDto>> findFriends(@PathVariable String clientId) throws Exception {
        if(friendsService.findFriends(clientId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(friendsService.findFriends(clientId));
    }

    @PostMapping("/")
    public ResponseEntity<String> registerFriend(@RequestParam String clientId, String friendClientId) throws Exception {
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
