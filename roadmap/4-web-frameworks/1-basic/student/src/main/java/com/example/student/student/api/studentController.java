package com.example.student.student.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.student.model.student;
import com.example.student.student.service.studentService;

@RestController
@RequestMapping("/student/")
public class studentController {

    private studentService _studentService;

    public studentController( studentService _studentService) {
        this._studentService = _studentService;
    }
    

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Isaac! ";
    }

    
    @PostMapping("/register")
    public void registerStudent(@RequestBody student _student) {
        _studentService.registerStudent(_student);
    }

    @GetMapping("/getStudent/{id}")
    public student getStudent(@PathVariable("id") int id) {           
        return _studentService.getStudent(id);
    }
}
