package com.example.student.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.student.model.student;

import java.util.ArrayList;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {

//    ArrayList<student> getStudents();
}
