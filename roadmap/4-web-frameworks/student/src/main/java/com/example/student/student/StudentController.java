package com.example.student.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/")
    public List<Student> hello() {
        return List.of(
                new Student(
                        394,
                        "Isla",
                        21,
                        LocalDate.of(2003, Month.MAY, 1),
                        "islarcherjr@gmail.com"
                )
        );
    }
}
