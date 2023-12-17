package com.example.meetingsmanagmentandorganization.controllers;

import com.example.meetingsmanagmentandorganization.model.User;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/secured")
public class MainController {
    private ApplicationContext applicationContext;
    private User user;
    @GetMapping("/user")
    public String userAccess(HttpSession session, Model model){
        if (session.getAttribute("username")==null){
            return "redirect:/auth";
        }
        model.addAttribute("role", session.getAttribute("role"));
        model.addAttribute("username", session.getAttribute("username"));
        return "user";
    }
    @GetMapping("/meetings")
    public String meetings(HttpSession session){
        if (session.getAttribute("username")==null){
            return "redirect:/auth";
        }
        return "meetings";
    }
}
