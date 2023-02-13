package com.numble.banking.repository;

import com.numble.banking.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findClientByClientIdAndClientPassword(String clientId, String clientPassword);

}
