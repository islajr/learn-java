package com.example.student.student.repository;

import com.example.student.student.model.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<role, Long> {

}
