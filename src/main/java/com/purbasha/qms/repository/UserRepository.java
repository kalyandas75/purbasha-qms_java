package com.purbasha.qms.repository;

import com.purbasha.qms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmailIgnoreCase(String email);
    Optional<User> findOneByLoginIgnoreCase(String login);
}
