package com.todoapp.backend_todo.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.todoapp.backend_todo.Repositories.userRepository;
import com.todoapp.backend_todo.Models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class customerUserDetail implements UserDetailsService {
    private userRepository userRepo;

    public customerUserDetail(userRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String UserName) {
        User user = userRepo.findByUserName(UserName);
        if (user == null) {
            throw new UsernameNotFoundException("Your token has expired");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String role : user.getUsers()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                grantedAuthorities);
    }
}
