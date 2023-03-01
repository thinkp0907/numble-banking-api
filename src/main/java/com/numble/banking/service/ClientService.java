package com.numble.banking.service;

import com.numble.banking.domain.Client;
import com.numble.banking.dto.ClientDto;
import com.numble.banking.exception.DuplicatedClientIdException;
import com.numble.banking.exception.ErrorCode;
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

    public ClientDto register(ClientDto clientDto) {
        ClientDto returnDto = null;

        boolean isExists = clientRepository.existsByClientId(clientDto.clientId());

        if(!isExists) {
            Client client = clientRepository.save(ClientDto.toEntity(clientDto));
            returnDto = ClientDto.toDto(client);
        } else {
            throw new DuplicatedClientIdException(ErrorCode.DUPLICATED_CLIENT_ID);
        }

        return returnDto;
    }


}
