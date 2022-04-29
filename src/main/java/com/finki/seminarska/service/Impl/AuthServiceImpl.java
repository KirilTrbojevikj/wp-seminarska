package com.finki.seminarska.service.Impl;

import com.finki.seminarska.model.User;
import com.finki.seminarska.model.exceptions.InvalidArgumentsException;
import com.finki.seminarska.model.exceptions.InvalidUserCredentialsException;
import com.finki.seminarska.repository.UserRepository;
import com.finki.seminarska.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
