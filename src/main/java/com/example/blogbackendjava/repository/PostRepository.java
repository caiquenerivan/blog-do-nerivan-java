package com.example.blogbackendjava.repository;

import com.example.blogbackendjava.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findAllByActiveTrue();
}