package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Student;
import com.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Student Registration
    @PostMapping("/register")
    public String registerStudent(@RequestParam("name") String name,
                                  @RequestParam("email") String email,
                                  @RequestParam("password") String password,
                                  Model model) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setPassword(password);
        
        // Save the student to the database
        studentService.saveStudent(student);
        
        model.addAttribute("message", "Student registered successfully!");
        return "login"; // Redirect to the shared login page
    }
}
