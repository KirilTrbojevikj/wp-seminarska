package com.finki.seminarska.service.Impl;

import com.finki.seminarska.model.Posts;
import com.finki.seminarska.repository.PostsRepository;
import com.finki.seminarska.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostsService {

    private final PostsRepository postsRepository;

    @Autowired
    public PostServiceImpl(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public List<Posts> findAll() {
        return this.postsRepository.findAll();
    }

    @Override
    public Optional<Posts> findById(Long id) {
        return this.postsRepository.findById(id);
    }

    @Override
    public Optional<Posts> save(Posts posts) {
        return Optional.empty();
    }

    @Override
    public Optional<Posts> edit(Long id, Posts posts) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
