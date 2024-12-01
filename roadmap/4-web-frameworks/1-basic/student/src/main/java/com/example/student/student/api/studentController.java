package com.example.student.student.api;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.student.student.model.student;
import com.example.student.student.service.studentService;

import java.util.ArrayList;

@RestController
@RequestMapping("/student/")
public class    studentController {

    private studentService _studentService;

    public studentController( studentService _studentService) {
        this._studentService = _studentService;
    }
    

    @GetMapping("/hello")
    public String hello(Authentication auth) {

        if (auth.isAuthenticated()) {
            return "Welcome, " + auth.getName() + "!";
        }

        // else
        return "Welcome, stranger!";
    }

    
    @PostMapping("/register")
    public void registerStudent(@RequestBody student _student) {
        _studentService.registerStudent(_student);
    }

    @GetMapping("/getStudent/{id}")
    public student getStudent(@PathVariable("id") Long id) {
        return _studentService.getStudent(id);
    }       

    @GetMapping("/getStudents")
    public ArrayList<student> getStudents() {
        return _studentService.getStudents();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        _studentService.deleteStudent(id);
    }

    @DeleteMapping("/deleteStudents")
    public void deleteAllStudents() {
        _studentService.deleteAllStudents();
    }

    @PutMapping("/updateStudent/{id}")
    public void updateStudent(
            @PathVariable("id") Long id,
            @RequestBody student _student
    ) {
        _studentService.updateStudent(id, _student);
    }

}
