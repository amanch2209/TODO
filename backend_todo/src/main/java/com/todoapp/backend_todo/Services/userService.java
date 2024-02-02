package com.todoapp.backend_todo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todoapp.backend_todo.Repositories.userRepository;
import com.todoapp.backend_todo.jwt.jwtTokenGenerator;
import com.todoapp.backend_todo.Models.User;
import com.todoapp.backend_todo.Controllers.userSigninResponse;
import com.todoapp.backend_todo.Controllers.userSigninRequest;
import com.todoapp.backend_todo.Controllers.userSignupRequest;
import com.todoapp.backend_todo.Controllers.userSignupResponse;
import org.springframework.security.core.AuthenticationException;
import com.todoapp.backend_todo.CustomExceptions.com.todoapp.backend_todo.CustomExceptions.java.badRequestException;

@Service
public class userService {
    @Autowired
    userRepository userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    jwtTokenGenerator jwtToken;

    public userSignupResponse signup(userSignupRequest userSignupRequest) {
        try {
            String username = userSignupRequest.getUsername();
            String password = userSignupRequest.getPassword();

            User user = userRepo.findByUserName(username);
            if (user != null) {
                throw new badRequestException("Username is already exist");
            }

            User _user = new User(username, passwordEncoder.encode(password));
            _user = userRepo.save(_user);

            String token = jwtToken.createToken(_user.getUserName(), _user.getUsers());

            return new userSignupResponse(username, token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password");
        }
    }

    public userSigninResponse signin(userSigninRequest userSigninRequest) {
        try {
            String username = userSigninRequest.getUsername();
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, userSigninRequest.getPassword()));
            String token = jwtToken.createToken(username,
                    this.userRepo.findByUserName(username).getUsers());

            return new userSigninResponse(username, token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password");
        }
    }

}
