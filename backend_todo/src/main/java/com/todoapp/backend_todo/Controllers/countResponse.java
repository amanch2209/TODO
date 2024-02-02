package com.todoapp.backend_todo.Controllers;

public class countResponse {
    private long count;

    protected countResponse() {

    }

    public countResponse(long count) {
        super();
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
