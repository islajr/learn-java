package com.example.student.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    @GetMapping("/")
    public List<Student> getStudents() {
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
