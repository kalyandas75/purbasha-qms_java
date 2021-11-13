package com.purbasha.qms.service;

import com.purbasha.qms.domain.User;
import com.purbasha.qms.repository.UserRepository;
import com.purbasha.qms.security.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<User> findUserByEmail() {
        return SecurityUtils.getCurrentUserLogin().flatMap(userRepository::findOneByEmailIgnoreCase);
    }

    @Transactional(readOnly = true)
    public Optional<User> findUserByLogin() {
        return SecurityUtils.getCurrentUserLogin().flatMap(userRepository::findOneByLoginIgnoreCase);
    }
}
