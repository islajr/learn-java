package com.example.student.student.repository;

import com.example.student.student.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user, Integer> {

    user findByUsername(String username);
}
