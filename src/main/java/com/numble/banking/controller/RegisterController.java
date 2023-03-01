package com.numble.banking.controller;

import com.numble.banking.dto.ClientDto;
import com.numble.banking.exception.DuplicatedClientIdException;
import com.numble.banking.exception.ErrorCode;
import com.numble.banking.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/register")
public class RegisterController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> register(@RequestBody ClientDto clientDto) {
        ClientDto clientDto1 = null;

        try {
            clientDto1 = clientService.register(clientDto);
        } catch (DuplicatedClientIdException e) {
            throw new DuplicatedClientIdException(ErrorCode.DUPLICATED_CLIENT_ID);
        }

        return ResponseEntity.ok(clientDto1);
    }
}
