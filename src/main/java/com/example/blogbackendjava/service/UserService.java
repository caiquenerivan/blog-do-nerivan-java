package com.example.blogbackendjava.service;

import com.example.blogbackendjava.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    List<User> findAllByActiveTrue();
    Optional<User> findById(String id);
    User update(User user);
    void deleteById(String id);
}
