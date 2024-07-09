package com.archer.todolist.dao;

import com.archer.todolist.model.todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface todoRepository extends JpaRepository<todo, Integer> {
    default Boolean checkTask(todo todo) {
        if (todo.getCompleted().equals(false)) {
            return false;
        }
        return true;
    }
}
