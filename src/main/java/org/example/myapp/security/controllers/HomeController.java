package org.example.myapp.security.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/home")
    public String homePage(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal != null) {
            String username = principal.getAttribute("name"); // Attribute 'name' contains user's name
            model.addAttribute("username", username);
        }
        return "home";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
