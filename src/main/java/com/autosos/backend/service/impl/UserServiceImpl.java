package com.autosos.backend.service.impl;

import com.autosos.backend.entity.User;
import com.autosos.backend.exception.ResourceNotFoundException;
import com.autosos.backend.repository.UserRepository;
import com.autosos.backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
