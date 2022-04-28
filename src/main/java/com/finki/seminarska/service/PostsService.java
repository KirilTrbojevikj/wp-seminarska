package com.finki.seminarska.service;

import com.finki.seminarska.model.Posts;

import java.util.List;
import java.util.Optional;

public interface PostsService {
    List<Posts> findAll();

    Optional<Posts> findById(Long id);

    Optional<Posts> save(Posts posts);

    Optional<Posts> edit(Long id, Posts posts);

    void deleteById(Long id);

}
