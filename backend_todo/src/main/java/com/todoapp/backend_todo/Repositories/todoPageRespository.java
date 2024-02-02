package com.todoapp.backend_todo.Repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.todoapp.backend_todo.Models.todoList;
import java.util.List;

public interface todoPageRespository extends PagingAndSortingRepository<todoList, Long> {
    List<todoList> findAllByUsername(String username, Pageable pageable);

    List<todoList> findAllByUsernameAndIsCompleted(String username, boolean isCompleted, Pageable pageable);
}
