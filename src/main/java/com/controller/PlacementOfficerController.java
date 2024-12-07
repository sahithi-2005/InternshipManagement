package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.PlacementOfficer;
import com.service.PlacementOfficerService;

@Controller
public class PlacementOfficerController {

    @Autowired
    private PlacementOfficerService placementOfficerService;

    // Placement Officer Registration
    @PostMapping("/officer/register")
    public String registerOfficer(@RequestParam("name") String name,
                                  @RequestParam("email") String email,
                                  @RequestParam("password") String password,
                                  Model model) {
        PlacementOfficer officer = new PlacementOfficer();
        officer.setName(name);
        officer.setEmail(email);
        officer.setPassword(password);
        placementOfficerService.savePlacementOfficer(officer);
        model.addAttribute("message", "Placement Officer registered successfully!");
        return "redirect:/login";
    }

    // Placement Officer Login
    @PostMapping("/officer/login")
    public String loginOfficer(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model) {
        PlacementOfficer officer = placementOfficerService.findOfficerByEmailAndPassword(email, password);
        if (officer != null) {
            model.addAttribute("user", officer);
            return "redirect:/officer-dashboard";
        }
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    // Placement Officer Dashboard
    @GetMapping("/officer-dashboard")
    public String showOfficerDashboard() {
        return "officer-dashboard"; // Return the placement officer dashboard view
    }
}
