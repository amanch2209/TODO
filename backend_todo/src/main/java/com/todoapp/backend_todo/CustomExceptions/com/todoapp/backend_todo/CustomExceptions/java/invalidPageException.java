package com.todoapp.backend_todo.CustomExceptions.com.todoapp.backend_todo.CustomExceptions.java;

public class invalidPageException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public invalidPageException(String message) {
        super(message);
    }
}
