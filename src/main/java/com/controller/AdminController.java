package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Admin;
import com.service.AdminService;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin Registration
    @PostMapping("/admin/register")
    public String registerAdmin(@RequestParam("username") String username,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password,
                                Model model) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setEmail(email);
        admin.setPassword(password);
        adminService.saveAdmin(admin);
        model.addAttribute("message", "Admin registered successfully!");
        return "redirect:/login";
    }

    // Admin Login
    @PostMapping("/admin/login")
    public String loginAdmin(@RequestParam("email") String email,
                             @RequestParam("password") String password,
                             Model model) {
        Admin admin = adminService.findAdminByEmailAndPassword(email, password);
        if (admin != null) {
            model.addAttribute("user", admin);
            return "redirect:/admin-dashboard";
        }
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    // Admin Dashboard
    @GetMapping("/admin-dashboard")
    public String showAdminDashboard() {
        return "admin-dashboard"; // Return the admin dashboard view
    }
}
