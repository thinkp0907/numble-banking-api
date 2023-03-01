package com.numble.banking.repository;

import com.numble.banking.domain.Client;
import com.numble.banking.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByClientIdAndClientPassword(String clientId, String clientPassword);

    Client findClientByClientId(String friendClientId);

    boolean existsByClientId(String clientId);

}
