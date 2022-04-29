package com.finki.seminarska.service;

import com.finki.seminarska.model.User;

public interface AuthService {

    User login(String username, String password);
}
