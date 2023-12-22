package com.example.blogbackendjava.service;

import com.example.blogbackendjava.domain.Comentario;

import java.util.List;
import java.util.Optional;

public interface ComentarioService {
    Comentario save(Comentario comentario);
    List<Comentario> findAllByActiveTrue();
    Optional<Comentario> findById(String id);
    Comentario update(Comentario comentario);
    void deleteById(String id);
}
