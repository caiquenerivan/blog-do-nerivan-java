package com.example.blogbackendjava.service;

import com.example.blogbackendjava.domain.User;
import com.example.blogbackendjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(User user){
        return userRepository.save(user);
    }
    @Override
    public List<User> findAllByActiveTrue() {
        return userRepository.findAllByActiveTrue();
    }
    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
