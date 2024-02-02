package com.todoapp.backend_todo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import javax.validation.*;

import java.util.List;

import com.todoapp.backend_todo.Models.todoList;
import com.todoapp.backend_todo.Services.todoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class todoController {
    @Autowired
    private todoService todoser;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/api/todo")
    public ResponseEntity<todoList> create(@Valid @RequestBody todoCreateTask createTask, Principal principal) {
        return new ResponseEntity<>(todoser.createTask(createTask, principal.getName()), HttpStatus.CREATED);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/api/todo")
    public ResponseEntity<List<todoList>> getAllTasks(Principal principal,
            @RequestParam(required = false) String isCompleted) {
        if (isCompleted != null) {
            return new ResponseEntity<>(todoser.getByIsCompleted(principal.getName(), isCompleted), HttpStatus.OK);
        }
        return new ResponseEntity<>(todoser.getAll(principal.getName()), HttpStatus.OK);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/api/todo/{id}")
    public ResponseEntity<todoList> getAllByID(@PathVariable long id, Principal principal) {
        return new ResponseEntity<>(todoser.getById(id, principal.getName()), HttpStatus.OK);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/api/todo/{id}/markComplete")
    public ResponseEntity<todoList> markComplete(@PathVariable long id, Principal principal) {
        return new ResponseEntity<>(todoser.markComplete(id, principal.getName()), HttpStatus.OK);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/api/todo/{id}")
    public ResponseEntity<todoList> updateTask(@PathVariable long id, @RequestBody todoUpdateTask updateTask,
            Principal principal) {
        return new ResponseEntity<>(todoser.updateById(id, updateTask, principal.getName()), HttpStatus.OK);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/todo/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable long id, Principal principal) {
        todoser.deleteById(id, principal.getName());
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/api/todo/count")
    public ResponseEntity<countResponse> countAll(Principal principal,
            @RequestParam(required = false) String isCompleted) {
        if (isCompleted != null) {
            return new ResponseEntity<>(todoser.countAllByIsCompleted(principal.getName(), isCompleted), HttpStatus.OK);
        }
        return new ResponseEntity<>(todoser.countAll(principal.getName()), HttpStatus.OK);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/api/todo/{pageNumber}/{pageSize}")
    public ResponseEntity<List<todoList>> readAllPages(Principal principal, @PathVariable String pageNumber,
            @PathVariable String pageSize, @RequestParam(required = false) String isCompleted) {
        if (isCompleted != null) {
            return new ResponseEntity<>(
                    todoser.readAllByIsCompletedPageable(principal.getName(), isCompleted, pageNumber, pageSize),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(todoser.readAllPageable(principal.getName(), pageNumber, pageSize), HttpStatus.OK);
    }

}
