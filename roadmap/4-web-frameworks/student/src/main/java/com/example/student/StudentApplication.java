package com.example.student;

import com.example.student.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

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
