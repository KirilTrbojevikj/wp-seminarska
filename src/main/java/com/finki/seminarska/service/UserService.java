package com.finki.seminarska.service;

import com.finki.seminarska.model.Posts;
import com.finki.seminarska.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User register(String username, String first_name, String last_name, String password, String repeatPassword, String email);

    List<Posts> ShowMyPosts();
}
