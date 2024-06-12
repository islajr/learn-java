package com.example.student.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StudentService {
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
