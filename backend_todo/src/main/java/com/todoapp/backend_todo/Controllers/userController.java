package com.todoapp.backend_todo.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.backend_todo.Repositories.userRepository;
import com.todoapp.backend_todo.Services.userService;
import com.todoapp.backend_todo.jwt.jwtTokenGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class userController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    jwtTokenGenerator jwtToken;

    @Autowired
    userRepository userRepo;

    @Autowired
    userService userService;

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping("/api/auth/signin")
    public ResponseEntity<userSigninResponse> signin(@Valid @RequestBody userSigninRequest userSigninRequest) {
        return new ResponseEntity<>(userService.signin(userSigninRequest), HttpStatus.OK);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PostMapping("/api/auth/signup")
    public ResponseEntity<userSignupResponse> signup(@Valid @RequestBody userSignupRequest userSignupRequest) {
        return new ResponseEntity<>(userService.signup(userSignupRequest), HttpStatus.OK);
    }

}
