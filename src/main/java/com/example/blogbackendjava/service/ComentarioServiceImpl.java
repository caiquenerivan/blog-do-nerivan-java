package com.example.blogbackendjava.service;

import com.example.blogbackendjava.domain.Comentario;
import com.example.blogbackendjava.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServiceImpl implements ComentarioService{
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Override
    public Comentario save(Comentario comentario){
        return comentarioRepository.save(comentario);
    }
    @Override
    public List<Comentario> findAllByActiveTrue() {
        return comentarioRepository.findAllByActiveTrue();
    }
    @Override
    public Optional<Comentario> findById(String id) {
        return comentarioRepository.findById(id);
    }
    @Override
    public Comentario update(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public void deleteById(String id) {
        comentarioRepository.deleteById(id);
    }
}
