package com.archer.todolist.dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class todoConfig {

    CommandLineRunner commandLineRunner(todoRepository repository) {
        return args -> {
            repository.saveAll(List.of());
        };
    }
}
