package com.archer.todolist.api;

import com.archer.todolist.model.todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
public class todoController {

    @GetMapping("/")

}
