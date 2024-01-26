package com.azhaan1.demo.repository;

import com.azhaan1.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student ,Long> {
    Optional<Student> findByEmail(String email);
}
