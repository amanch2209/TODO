package com.todoapp.backend_todo.Services;

import com.todoapp.backend_todo.Models.todoList;
import com.todoapp.backend_todo.Repositories.todoRepository;
import com.todoapp.backend_todo.Repositories.todoPageRespository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.todoapp.backend_todo.Controllers.todoCreateTask;
import com.todoapp.backend_todo.Controllers.todoUpdateTask;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.todoapp.backend_todo.Controllers.countResponse;
import com.todoapp.backend_todo.CustomExceptions.com.todoapp.backend_todo.CustomExceptions.java.invalidPageException;

@Service
public class todoService {
    @Autowired
    todoRepository todoRepo;
    todoPageRespository todoPage;

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

    public countResponse countAll(String username) {
        return new countResponse(todoRepo.countByUserName(username));
    }

    public countResponse countAllByIsCompleted(String username, String isCompleted) {
        boolean _isCompleted = isCompletedBoolean(isCompleted);
        return new countResponse(todoRepo.countByUserNameAndIsCompleted(username, _isCompleted));
    }

    public List<todoList> readAllPageable(String username, String pageNumber, String pageSize) {
        int _pageNumber = pageNumberStringToInteger(pageNumber);
        int _pageSize = pageSizeToInteger(pageSize);

        Pageable pageable = PageRequest.of(_pageNumber, _pageSize, Sort.by(Sort.Direction.ASC, "targetDate"));
        return todoPage.findAllByUsername(username, pageable);
    }

    public List<todoList> readAllByIsCompletedPageable(String username, String isCompleted, String pageNumber,
            String pageSize) {
        boolean _isCompleted = isCompletedBoolean(isCompleted);
        int _pageNumber = pageNumberStringToInteger(pageNumber);
        int _pageSize = pageSizeToInteger(pageSize);

        Pageable pageable = PageRequest.of(_pageNumber, _pageSize, Sort.by(Sort.Direction.ASC, "targetDate"));
        return todoPage.findAllByUsernameAndIsCompleted(username, _isCompleted, pageable);
    }

    private int pageSizeToInteger(String pageSize) {
        int _pageSize;

        try {
            _pageSize = Integer.parseInt(pageSize);
        } catch (Exception e) {
            throw new invalidPageException("Invalid Page Size");
        }

        if (_pageSize < 1) {
            throw new invalidPageException("Invalid page size");
        }

        return _pageSize;
    }

    private int pageNumberStringToInteger(String pageNumber) {
        int _pageNumber;

        try {
            _pageNumber = Integer.parseInt(pageNumber);
        } catch (Exception e) {
            throw new invalidPageException("Invalid Page Number");
        }

        if (_pageNumber < 0) {
            throw new invalidPageException("Invalid page number");
        }

        return _pageNumber;
    }

}
