package com.archer.todolist.api;

import com.archer.todolist.model.todo;
import com.archer.todolist.service.todoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/todo")
public class todoController {

    private final todoService _todoservice;

    public todoController(todoService service) {
        this._todoservice = service;
    }

    @PostMapping("/create")
    public void createItem(@RequestBody todo todo) {
        _todoservice.createItem(todo);
    }

    @GetMapping("/getItems")
    public List<todo> getTodos() {
       return _todoservice.getItems();
    }

    @GetMapping("/getItems/{id}")
    public Optional<todo> getTodo(@PathVariable int id) {
        return _todoservice.getItem(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable int id) {
        _todoservice.deleteItem(id);
    }

    @PutMapping("/update/{id}")
    public void updateItem(
            @PathVariable int id,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) Boolean isCompleted,
            todo todo
    ) {
       _todoservice.updateItem(id, name, isCompleted, todo);
    }



}
