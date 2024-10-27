package com.example.student.student.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.student.student.model.student;

@Component
public class studentdao {

    private ArrayList<student> students = new ArrayList<>();

    public int register(student _student) {

        try {   
            students.add(_student);
            return 0;
            
        } catch (Exception e) {
            System.out.println(e.toString());
            return 1;
        }
    }

}
