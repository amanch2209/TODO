package com.todoapp.backend_todo.CustomExceptions.com.todoapp.backend_todo.CustomExceptions.java;

public class invalidJwtAuthenticationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public invalidJwtAuthenticationException(String message) {
        super(message);
    }
}
