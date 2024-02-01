package com.todoapp.backend_todo.Controllers;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class todoUpdateTask {
    @NotEmpty(message = "Title of the task is mandatory")
    private String title;

    @NotNull(message = "Due Date is required")
    private Date dueDate;

    public todoUpdateTask(String title, Date dueDate) {
        super();
        this.title = title;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
