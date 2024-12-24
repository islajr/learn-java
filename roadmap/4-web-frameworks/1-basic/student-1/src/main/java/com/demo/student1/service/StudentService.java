package com.demo.student1.service;

import com.demo.student1.model.Student;
import com.demo.student1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }
}
