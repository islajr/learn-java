package com.archer.todolist.service;

import com.archer.todolist.model.todo;
import com.archer.todolist.dao.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class todoService {

    private final todoRepository repository;

    @Autowired
    public todoService(todoRepository repository) {
        this.repository = repository;
    }

    public void createItem(todo todo) {
        repository.save(todo);
    }
}
