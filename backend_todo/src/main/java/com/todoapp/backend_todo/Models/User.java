package com.todoapp.backend_todo.Models;

import javax.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty(message = "Username is required")
    @Column(unique = true)
    private String userName;

    @NotEmpty(message = "Password is required")
    private String password;

    private String role;

    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
        this.role = "User";
    }

    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getUsers() {
        return Arrays.asList(this.role);
    }

    public void setUsers(String role) {
        this.role = role;
    }

}
