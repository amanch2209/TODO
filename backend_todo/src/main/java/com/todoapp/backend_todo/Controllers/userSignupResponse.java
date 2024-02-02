package com.todoapp.backend_todo.Controllers;

public class userSignupResponse {
    private String username;
    private String token;

    protected userSignupResponse() {

    }

    public userSignupResponse(String username, String token) {
        super();
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
