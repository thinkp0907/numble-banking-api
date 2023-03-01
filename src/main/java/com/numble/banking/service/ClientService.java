package com.numble.banking.service;

import com.numble.banking.domain.Client;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.repository.ClientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ClientService {

    private final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;

    public String register(ClientDto clientDto) {
        String resultMessage = "이미 존재하는 ID 입니다.";

        boolean isExists = clientRepository.existsByClientId(clientDto.clientId());

        if(!isExists) {
            clientRepository.save(ClientDto.toEntity(clientDto));
            resultMessage = "회원가입이 완료되었습니다.";
        }

        return resultMessage;
    }


}
