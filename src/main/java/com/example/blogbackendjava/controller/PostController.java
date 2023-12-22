package com.example.blogbackendjava.controller;

import com.example.blogbackendjava.domain.Post;
import com.example.blogbackendjava.dto.PostRequestDTO;
import com.example.blogbackendjava.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity getAllPosts(){
        var allUsers = postService.findAllByActiveTrue();
        return ResponseEntity.ok(allUsers);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity getPostById(@PathVariable String id){
        Optional<Post> optionalPost = postService.findById(id);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            return ResponseEntity.ok(post);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @PostMapping
    public ResponseEntity registerPost(@RequestBody @Valid PostRequestDTO data){
        Post newPost = new Post(data);
        postService.save(newPost);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updatePost(@PathVariable String id, @RequestBody PostRequestDTO data){
        Optional<Post> optionalPost = postService.findById(id);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();

            post.setTitulo(data.titulo());
            post.setSubTitulo(data.subTitulo());
            post.setCapa(data.capa());
            post.setTexto(data.texto());
            post.setPostCategoria(data.postCategoria());
            post.setDataAtualizacao(LocalDate.now().toString());
            post.setHoraAtualizacao(LocalTime.now().toString());
            post.setLikes(data.likes());

            return  ResponseEntity.ok(post);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePost(@PathVariable String id){
        Optional<Post> optionalPost = postService.findById(id);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();

            post.setActive(false);

            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}


