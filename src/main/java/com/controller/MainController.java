package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // This handles the request for the home page
	@GetMapping("/")
	public String home(Model model) {
	    model.addAttribute("title", "Welcome to the Placement Interaction Tracker System");
	    return "index";  // Ensure this matches your `index.html` file in the templates folder.
	}

    // This handles the request for the login page
    @GetMapping("/login")
    public String login() {
        return "login"; // This will return the login.html page
    }

    // This handles the request for the register page (for students)
    @GetMapping("/register")
    public String register() {
        return "register"; // This will return the register.html page
    }

    // This handles the about us page request
    @GetMapping("/about")
    public String about() {
        return "about"; // This will return the about.html page
    }

    // This handles the contact us page request
    @GetMapping("/contact")
    public String contact() {
        return "contact"; // This will return the contact.html page
    }
    @GetMapping("/student-dashboard")
    public String studentDashboard() {
        return "student-dashboard";  // This should match the name of your .html file in the templates folder
    }
    
    // Add any other general endpoints here as needed

}
