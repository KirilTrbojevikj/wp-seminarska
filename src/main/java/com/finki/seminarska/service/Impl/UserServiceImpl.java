package com.finki.seminarska.service.Impl;

import com.finki.seminarska.model.Posts;
import com.finki.seminarska.model.User;
import com.finki.seminarska.model.exceptions.InvalidUsernameOrPasswordException;
import com.finki.seminarska.model.exceptions.PasswordsDoNotMatchException;
import com.finki.seminarska.model.exceptions.UsernameAlreadyExistsException;
import com.finki.seminarska.repository.UserRepository;
import com.finki.seminarska.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }
    @Override
    public User register(String username, String first_name, String last_name, String password, String repeatPassword, String email) {

        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);

        User user = new User(username, passwordEncoder.encode(password), first_name, last_name,email);
        return userRepository.save(user);
    }

    @Override
    public List<Posts> ShowMyPosts() {
        return null;
    }
}
