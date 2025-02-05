package com.demo.student1.service;

import com.demo.student1.model.Student;
import com.demo.student1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public void registerStudent(Student student) {
        studentRepository.save(student);
    }

    public ArrayList<Student> getStudents() {
        return (ArrayList<Student>) studentRepository.findAll();
    }

}
