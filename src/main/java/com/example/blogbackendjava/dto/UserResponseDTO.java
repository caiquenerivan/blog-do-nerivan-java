package com.example.blogbackendjava.dto;

import com.example.blogbackendjava.domain.User;
import com.example.blogbackendjava.domain.UserType;

public record UserResponseDTO(String id, String name, String nickname, String email, String password, UserType userType, String about, String linkedin, String twitter, String instagram) {
    public UserResponseDTO(User user){
        this(user.getId(),user.getName(), user.getNickname(), user.getEmail(), user.getPassword(), user.getUserType(), user.getAbout(), user.getLinkedin(), user.getTwitter(), user.getInstagram());
    }
}
