package com.todoapp.backend_todo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.backend_todo.Models.User;

public interface userRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
