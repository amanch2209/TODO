package com.todoapp.backend_todo.Models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class todoList {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty(message = "Title of the task is mandatory")
    private String title;

    @NotNull(message = "Due date is required")
    private Date dueDate;

    private String userName;
    private boolean isCompleted;

    public todoList(String title, Date dueDate, String userName) {
        super();
        this.title = title;
        this.dueDate = dueDate;
        this.userName = userName;
        this.isCompleted = false;
    }

    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "TODO [id = " + id + " , title = " + title + " , dueDate = " + dueDate + " , userName = " + userName
                + " , isCompleted = " + isCompleted + "]";
    }

}
