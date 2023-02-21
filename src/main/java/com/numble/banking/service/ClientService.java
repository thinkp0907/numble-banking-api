package com.numble.banking.service;

import com.numble.banking.domain.Client;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.repository.ClientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ClientService {

    private static ClientRepository clientRepository;

    public String register(ClientDto clientDto) {
        String resultMessage = "이미 존재하는 ID 입니다.";

        if(!clientRepository.existsByClientId(clientDto.clientId())) {
            clientRepository.save(ClientDto.toEntity(clientDto));
            resultMessage = "회원가입이 완료되었습니다.";
        }

        return resultMessage;
    }


}
