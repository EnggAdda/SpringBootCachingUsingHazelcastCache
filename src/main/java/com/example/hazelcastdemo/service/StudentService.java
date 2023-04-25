package com.example.hazelcastdemo.service;



import com.example.hazelcastdemo.entity.Student;

import java.util.List;

public interface StudentService {



        List<Student> getAllStudents();
        Student getStudentById(Integer studentId);
        Student createStudent(Student student);
        Student updateStudent(Student student,  Integer studentId);
        Student deleteStudent(Integer studentId);


}
