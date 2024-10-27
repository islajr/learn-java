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

    public student getStudent(int id) throws Exception {
        return students.get(id - 1);
    }

}
