package com.example.hazelcastdemo.repository;


import com.example.hazelcastdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
