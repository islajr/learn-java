package com.demo.student1.api;

import com.demo.student1.model.Student;
import com.demo.student1.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RequestMapping("/student")
@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("username", "John Doe");
        return "home";
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
