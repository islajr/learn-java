package com.demo.student1.api;

import com.demo.student1.model.Student;
import com.demo.student1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, Isla!";
    }

    @PostMapping("/register")
    public void registerStudent(@RequestBody Student student) {
        studentService.registerStudent(student);
    }

    @GetMapping("/get_student/{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/getStudents")
    public ArrayList<Student> getStudents() {
        return studentService.getStudents();
    }

}
