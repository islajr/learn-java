package com.example.student.student.service;

import org.springframework.stereotype.Service;

import com.example.student.student.dao.studentdao;
import com.example.student.student.model.student;

@Service
public class studentService {

    private studentdao _studentdao;

    public studentService(studentdao _studentdao) {
        this._studentdao = _studentdao;
    }

    public void registerStudent(student _student) {
        _studentdao.register(_student);
    }


}
