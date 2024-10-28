package com.example.student.student.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.student.student.exception.studentAlreadyExistsException;
import com.example.student.student.exception.studentDoesNotExistException;
import com.example.student.student.model.student;

@Component
public class studentdao {

    private ArrayList<student> students = new ArrayList<>();

    public void register(student _student) {
        try {
            students.add(_student);
            
        } catch (studentAlreadyExistsException e) {
            System.out.println(e.toString());
        }
    }

    public student getStudent(int id) {
        if (students.get(id - 1) != null) {
            return students.get(id - 1);
        }
        else {
            throw new studentDoesNotExistException("Student does not exist! ");
        }
    }

}
