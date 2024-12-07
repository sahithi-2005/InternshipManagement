package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Admin;
import com.model.Employer;
import com.model.PlacementOfficer;
import com.model.Student;
import com.service.AdminService;
import com.service.EmployerService;
import com.service.PlacementOfficerService;
import com.service.StudentService;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private EmployerService employerService;
    
    @Autowired
    private PlacementOfficerService officerService;
    
    @Autowired
    private StudentService studentService;

    // Shared login method for all roles
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        // Check Admin
        Admin admin = adminService.findAdminByEmailAndPassword(email, password);
        if (admin != null) {
            return "redirect:/admin-dashboard";
        }

        // Check Employer
        Employer employer = employerService.findEmployerByEmailAndPassword(email, password);
        if (employer != null) {
            return "redirect:/employer-dashboard.html";
        }

        // Check Placement Officer
        PlacementOfficer officer = officerService.findOfficerByEmailAndPassword(email, password);
        if (officer != null) {
            return "redirect:/officer-dashboard";
        }

        // Check Student
        Student student = studentService.findStudentByEmailAndPassword(email, password);
        if (student != null) {
            return "redirect:/student-dashboard";
        }

        // If none found, return to login page with an error
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
}
