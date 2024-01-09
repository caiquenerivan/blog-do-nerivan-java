package com.example.blogbackendjava.service;

import com.example.blogbackendjava.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post save(Post post);
    List<Post> findAllByActiveTrue();
    Optional<Post> findById(String id);
    Post update(Post post);
    void deleteById(String id);
}
