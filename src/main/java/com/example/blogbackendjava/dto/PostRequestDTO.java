package com.example.blogbackendjava.dto;

import com.example.blogbackendjava.domain.Comentario;
import com.example.blogbackendjava.domain.PostCategoria;
import com.example.blogbackendjava.domain.User;

import java.time.LocalDateTime;
import java.util.List;

public record PostRequestDTO(
        String titulo,
        String subTitulo,
        String capa,
        String texto,
        PostCategoria postCategoria,
        User users,
        Integer likes
        ) {
}
