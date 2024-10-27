package com.archer.todolist.dao;

import com.archer.todolist.model.todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface todoRepository extends JpaRepository<todo, Integer> {
}
