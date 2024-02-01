package com.todoapp.backend_todo.Services;

import com.todoapp.backend_todo.Models.todoList;
import com.todoapp.backend_todo.Repositories.todoRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todoapp.backend_todo.Controllers.todoCreateTask;
import com.todoapp.backend_todo.Controllers.todoUpdateTask;

@Service
public class todoService {
    @Autowired
    private todoRepository todoRepo;

    public todoList createTask(todoCreateTask createTodoTask, String userName) {
        todoList todo = new todoList(createTodoTask.getTitle(), createTodoTask.getDueDate(), userName);
        return todoRepo.save(todo);
    }

    public todoList getById(long id, String userName) {
        todoList todo = todoRepo.findByUserNameAndId(userName, id);
        return todo;
    }

    public List<todoList> getAll(String userName) {
        return this.todoRepo.findByUserName(userName);
    }

    public List<todoList> getByIsCompleted(String userName, String isCompleted) {
        boolean _isCompleted = isCompletedBoolean(isCompleted);
        return this.todoRepo.findAllByUserNameAndIsCompleted(userName, _isCompleted);
    }

    public void deleteById(long id, String userName) {
        todoList todo = todoRepo.findByUserNameAndId(userName, id);
        if (todo != null) {
            todoRepo.deleteById(id);
        }
    }

    public todoList updateById(long id, todoUpdateTask updateTodoTask, String userName) {
        todoList todo = todoRepo.findByUserNameAndId(userName, id);
        todo.setTitle(updateTodoTask.getTitle());
        todo.setDueDate(updateTodoTask.getDueDate());
        return todoRepo.save(todo);
    }

    public todoList markComplete(long id, String userName) {
        todoList todo = todoRepo.findByUserNameAndId(userName, id);
        todo.setIsCompleted(!todo.getIsCompleted());
        return todoRepo.save(todo);
    }

    private boolean isCompletedBoolean(String isCompleted) {
        return Boolean.parseBoolean(isCompleted);
    }

}
