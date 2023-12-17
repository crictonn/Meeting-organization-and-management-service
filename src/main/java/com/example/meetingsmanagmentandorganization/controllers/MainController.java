package com.example.meetingsmanagmentandorganization.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
@RequestMapping("/secured")
public class MainController {
    @GetMapping("/user")
    public String userAccess(Principal principal){
//        if(principal == null)
//            return "redirect:/auth";
        return "user";
    }
//    @GetMapping("/user")
//    public String user(){
//        return "user";
//    }
}
