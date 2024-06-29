package com.archer.todolist.service;

import com.archer.todolist.model.todo;
import com.archer.todolist.dao.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class todoService {

    private final todoRepository repository;

    @Autowired
    public todoService(todoRepository repository) {
        this.repository = repository;
    }

    public void createItem(todo todo) {
        todo.setTimeIssued(LocalDateTime.now());
        todo.setCompleted(false);
        repository.save(todo);
    }

    public List<todo> getItems() {
        return repository.findAll();
    }

    public Optional<todo> getItem(int id) {
        Optional<todo> item = repository.findById(id);

        if (item.isEmpty()) {
            throw new IllegalStateException("Item does not exist! ");
        }
        // else
        return item;
    }
}
