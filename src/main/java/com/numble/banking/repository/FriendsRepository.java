package com.numble.banking.repository;

import com.numble.banking.domain.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {

}
