package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Employer;
import com.service.EmployerService;

@Controller
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    // Employer Registration
    @PostMapping("/employer/register")
    public String registerEmployer(@RequestParam("companyName") String companyName,
                                   @RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   Model model) {
        Employer employer = new Employer();
        employer.setCompanyName(companyName);
        employer.setEmail(email);
        employer.setPassword(password);
        employerService.saveEmployer(employer);
        model.addAttribute("message", "Employer registered successfully!");
        return "redirect:/login";
    }

    // Employer Login
    @PostMapping("/employer/login")
    public String loginEmployer(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                Model model) {
        Employer employer = employerService.findEmployerByEmailAndPassword(email, password);
        if (employer != null) {
            model.addAttribute("user", employer);
            return "redirect:/employer-dashboard";
        }
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    // Employer Dashboard
    @GetMapping("/employer-dashboard")
    public String showEmployerDashboard() {
        return "employer-dashboard"; // Return the employer dashboard view
    }
}
