package com.todoapp.backend_todo.Controllers;

public class userSigninRequest {
    private String username;

    private String password;

    protected userSigninRequest() {

    }

    public userSigninRequest(String username, String password) {
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
