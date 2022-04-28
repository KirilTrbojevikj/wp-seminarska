package com.finki.seminarska.service.Impl;

import com.finki.seminarska.model.User;
import com.finki.seminarska.model.exceptions.InvalidUsernameOrPasswordException;
import com.finki.seminarska.model.exceptions.PasswordsDoNotMatchException;
import com.finki.seminarska.model.exceptions.UsernameAlreadyExistsException;
import com.finki.seminarska.repository.UserRepository;
import com.finki.seminarska.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String first_name, String last_name, String password, String repeatPassword, String email) {

        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);

        //User user = new User(username,passwordEncoder.encode(password),name,surname,userRole);
        User user = new User(username, first_name, last_name, email);
        return userRepository.save(user);
    }
}
