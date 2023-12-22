package com.example.blogbackendjava.controller;

import com.example.blogbackendjava.domain.Comentario;
import com.example.blogbackendjava.dto.ComentarioRequestDTO;
import com.example.blogbackendjava.service.ComentarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity getAllComments(){
        var allComments = comentarioService.findAllByActiveTrue();
        return ResponseEntity.ok(allComments);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity getCommentById(@PathVariable String id){
        Optional<Comentario> optionalComentario = comentarioService.findById(id);
        if (optionalComentario.isPresent()){
            Comentario comentario = optionalComentario.get();
            return ResponseEntity.ok(comentario);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @PostMapping
    public ResponseEntity registerComment(@RequestBody @Valid ComentarioRequestDTO data){
        Comentario newComentario = new Comentario(data);
        comentarioService.save(newComentario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateComment(@PathVariable String id, @RequestBody ComentarioRequestDTO data){
        Optional<Comentario> optionalComentario = comentarioService.findById(id);
        if (optionalComentario.isPresent()){
            Comentario comentario = optionalComentario.get();

            comentario.setTexto(data.texto());
            comentario.setLikes(data.likes());

            return ResponseEntity.ok(comentario);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteComment(@PathVariable String id){
        Optional<Comentario> optionalComentario = comentarioService.findById(id);
        if (optionalComentario.isPresent()){
            Comentario comentario = optionalComentario.get();
            comentario.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
