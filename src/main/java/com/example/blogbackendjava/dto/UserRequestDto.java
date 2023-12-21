package com.example.blogbackendjava.dto;

import com.example.blogbackendjava.domain.UserType;

public record UserRequestDto(String name, String nickname, String email, String password, UserType userType, String about, String linkedin, String twitter, String instagram) {
}
