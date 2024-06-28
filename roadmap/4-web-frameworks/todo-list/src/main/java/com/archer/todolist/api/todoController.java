package com.archer.todolist.api;

import com.archer.todolist.model.todo;
import com.archer.todolist.service.todoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

}
