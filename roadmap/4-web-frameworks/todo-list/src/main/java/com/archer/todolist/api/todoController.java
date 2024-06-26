package com.archer.todolist.api;

import com.archer.todolist.model.todo;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/todo")
public class todoController {

    @PostMapping("/create")
    public void createItem() {

    }

}
