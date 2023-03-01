package com.numble.banking.controller;

import com.numble.banking.dto.ClientDto;
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
    public ResponseEntity<String> register(@RequestBody ClientDto clientDto) {
        String returnResult = clientService.register(clientDto);

        return ResponseEntity.ok(returnResult);
    }
}
