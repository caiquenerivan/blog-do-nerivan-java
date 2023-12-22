package com.example.blogbackendjava.repository;

import com.example.blogbackendjava.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, String> {
    List<Comentario> findAllByActiveTrue();
}
