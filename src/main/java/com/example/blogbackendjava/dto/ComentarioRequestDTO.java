package com.example.blogbackendjava.dto;

import com.example.blogbackendjava.domain.Post;
import com.example.blogbackendjava.domain.User;

public record ComentarioRequestDTO(
        User users,
        String texto,
        Post posts,
        Integer likes
) {
}
