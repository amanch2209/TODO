package com.todoapp.backend_todo.Controllers;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class userSignupRequest {
    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "Password is required")
    @Size(min = 8, message = "Password length should be 8 characters or more")
    private String password;

    protected userSignupRequest() {

    }

    public userSignupRequest(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
