package com.autosos.backend.service;

import com.autosos.backend.entity.User;

public interface UserService {
    User findByUsername(String username);
    User save(User user);
}
