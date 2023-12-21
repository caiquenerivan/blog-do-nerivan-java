package com.example.blogbackendjava.controller;

import com.example.blogbackendjava.domain.User;
import com.example.blogbackendjava.dto.UserRequestDto;
import com.example.blogbackendjava.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAllUsers(){
        var allUsers = userService.findAllByActiveTrue();
        return ResponseEntity.ok(allUsers);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable String id){
        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            return ResponseEntity.ok(user);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @PostMapping()
    public ResponseEntity registerUser(@RequestBody @Valid UserRequestDto data){
        User newUser = new User(data);
        userService.save(newUser);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateUser(@PathVariable String id, @RequestBody UserRequestDto data){
        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setName(data.name());
            user.setNickname(data.nickname());
            user.setEmail(data.email());
            user.setPassword(data.password());
            user.setUserType(data.userType());
            user.setAbout(data.about());
            user.setLinkedin(data.linkedin());
            user.setTwitter(data.twitter());
            user.setInstagram(data.instagram());

            return ResponseEntity.ok(user);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable String id){
        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }

}
