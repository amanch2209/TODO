package com.todoapp.backend_todo.Repositories;

import com.todoapp.backend_todo.Models.todoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface todoRepository extends JpaRepository<todoList, Long> {
    List<todoList> findByUserName(String userName);

    List<todoList> findAllByUserNameAndIsCompleted(String username, boolean isCompleted);

    todoList findByUserNameAndId(String userName, long Id);

    Long countByUserName(String userName);

    Long countByUserNameAndIsCompleted(String userName, boolean isCompleted);
}
