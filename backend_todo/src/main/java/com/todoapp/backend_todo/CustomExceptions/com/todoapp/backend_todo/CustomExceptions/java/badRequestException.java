package com.todoapp.backend_todo.CustomExceptions.com.todoapp.backend_todo.CustomExceptions.java;

public class badRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public badRequestException(String message) {
        super(message);
    }
}
