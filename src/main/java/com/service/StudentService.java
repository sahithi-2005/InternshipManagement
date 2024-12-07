package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Student;
import com.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void registerStudent(Student student) {
        // Save the student to the database
        studentRepository.save(student);
    }

    // Other service methods can be added as needed
}
