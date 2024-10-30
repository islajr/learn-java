package com.example.student.student.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.student.student.exception.studentDoesNotExistException;
import com.example.student.student.model.student;
import com.example.student.student.repository.studentRepository;

@Service
public class studentService {

    private studentRepository _studentRepository;

    public studentService(studentRepository _studentRepository) {
        this._studentRepository = _studentRepository;
    }

    public void registerStudent(student _student) {
        _studentRepository.save(_student);
        
    }

    public student getStudent(Long id) {
        Optional<student> __student = _studentRepository.findById(id);
        
        if (__student.isPresent()) {
            return __student.get();
        }
        else {
            throw new studentDoesNotExistException("There isn't such a student.");
        }
    }

    public ArrayList<student> getStudents() {
        return (ArrayList<student>) _studentRepository.findAll();
    }
}
