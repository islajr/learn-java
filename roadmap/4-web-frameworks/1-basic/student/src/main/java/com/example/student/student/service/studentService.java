package com.example.student.student.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.student.student.exception.noRegisteredStudentException;
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
        ArrayList<student> students = (ArrayList<student>) _studentRepository.findAll();

        if (students.isEmpty()) {
            throw new noRegisteredStudentException("There is no available Student.");
        }
        else {
            return students;
        }
    }

    public void deleteStudent(Long id) {
        if (_studentRepository.existsById(id)) {
            _studentRepository.deleteById(id);
        }
        else {
            throw new studentDoesNotExistException("Cannot delete a non-existent student.");
        }
    }

    public void deleteAllStudents() {
        ArrayList<student> students = (ArrayList<student>) _studentRepository.findAll();

        if (students.isEmpty()) {
            throw new studentDoesNotExistException("Cannot delete non-existent students. ");
        }
        _studentRepository.deleteAll();
    }

    public void updateStudent(student _student, Long id) {
        student test = _studentRepository.findById(id).get();

        if (test != null && _student != null) {

            test.setId(id);

            if (_student.getName() != null) {
                test.setName(_student.getName());
            }
            if (_student.getEmail() != null) {
                test.setEmail(_student.getEmail());
            }

            _studentRepository.save(test);
        }
        else {
            throw new studentDoesNotExistException("Cannot update details of a non-student.");
        }

    }
}
