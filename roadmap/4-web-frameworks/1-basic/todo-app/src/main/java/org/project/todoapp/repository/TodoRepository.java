package org.project.todoapp.repository;

import org.project.todoapp.model.Status;
import org.project.todoapp.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findTodoByUser_Email(String userEmail, Pageable pageable);


//    List<Todo> findAll(Pageable pageable);

    Page<Todo> findTodoByUser_EmailAndStatus(String email, Pageable pageable, Status status);
    Page<Todo> findTodoByStatus(Status status, Pageable pageable);
}
