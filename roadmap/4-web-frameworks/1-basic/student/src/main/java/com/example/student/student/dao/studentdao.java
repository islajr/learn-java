package com.example.student.student.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.student.student.model.student;

@Component
public class studentdao {

    private ArrayList<student> students = new ArrayList<>();

    public void register(student _student) {
        try {
            students.add(_student);
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public student getStudent(int id) {
        if (students.get(id - 1) != null) {
            return students.get(id - 1);
        }
        else {
            System.out.println("Student does not exist! ");
            throw new IndexOutOfBoundsException("Student does not exist!");
        }
    }

}
