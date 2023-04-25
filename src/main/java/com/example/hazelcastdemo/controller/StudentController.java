package com.example.hazelcastdemo.controller;

import com.example.hazelcastdemo.entity.Student;
import com.example.hazelcastdemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Slf4j
@CacheConfig(cacheNames  = "students")
public class StudentController {

     @Autowired
    private StudentService studentService;



    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id")
    public Student getStudentById(@PathVariable Integer id) {
        log.info("fetching the student with id " + id + "from DB");
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    @CachePut(key = "#id")
    public Student updateStudent( @RequestBody Student student,@PathVariable Integer id) {
        return studentService.updateStudent(student , id);
    }


    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id")
    public Student deleteStudent(@PathVariable Integer id) {
       return studentService.deleteStudent(id);
    }
}

