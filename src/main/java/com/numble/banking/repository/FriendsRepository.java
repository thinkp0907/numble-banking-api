package com.numble.banking.repository;

import com.numble.banking.domain.Friends;
import com.numble.banking.dto.FriendsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {

    List<Friends> findFriendsByClientId(String clientId);
}
