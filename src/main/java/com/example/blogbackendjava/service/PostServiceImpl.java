package com.example.blogbackendjava.service;

import com.example.blogbackendjava.domain.Post;
import com.example.blogbackendjava.domain.User;
import com.example.blogbackendjava.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public Post save(Post post){
        return postRepository.save(post);
    }
    @Override
    public List<Post> findAllByActiveTrue() {
        return postRepository.findAllByActiveTrue();
    }
    @Override
    public Optional<Post> findById(String id) {
        return postRepository.findById(id);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(String id) {
        postRepository.deleteById(id);
    }
}
