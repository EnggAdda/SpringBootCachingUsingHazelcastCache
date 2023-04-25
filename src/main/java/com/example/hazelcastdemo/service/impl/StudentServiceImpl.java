package com.example.hazelcastdemo.service.impl;

import com.example.hazelcastdemo.entity.Student;
import com.example.hazelcastdemo.repository.StudentRepo;
import com.example.hazelcastdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class StudentServiceImpl implements StudentService {

        @Autowired
        private StudentRepo studentRepository;


    @Override
    public List<Student> getAllStudents() {
       return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) {
       return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Integer studentId) {
       Student student1 = studentRepository.findById(studentId).orElse(null);
       student1.setFirstName(student.getFirstName());
       student1.setLastName(student.getLastName());
       student1.setAge(student.getAge());

        return studentRepository.save(student1);
    }

    @Override
    public Student deleteStudent(Integer studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
       studentRepository.deleteById(studentId);
       return student;
    }
}
