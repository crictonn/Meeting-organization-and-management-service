package com.example.meetingsmanagmentandorganization.controllers;

import com.example.meetingsmanagmentandorganization.model.Meeting;
import com.example.meetingsmanagmentandorganization.repository.MeetingRepository;
import com.example.meetingsmanagmentandorganization.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@Controller
@RequestMapping("/secured")
public class MainController {
    @Autowired
    private MeetingRepository meetingRepository;
    @Autowired
    private UserRepository userRepository;
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
    public String meetings(HttpSession session, Model model){
        if (session.getAttribute("username")==null){
            return "redirect:/auth";
        }
        model.addAttribute("role", session.getAttribute("role"));
        model.addAttribute("username", session.getAttribute("username"));
        return "meetings";
    }
    @GetMapping("/manageusers")
    public String userManagement(HttpSession session, Model model){
        if(session.getAttribute("username")==null){
            return "redirect:/auth";
        }
        model.addAttribute("role", session.getAttribute("role"));
        model.addAttribute("username", session.getAttribute("username"));
        return "manageusers";
    }
    @GetMapping("/addmeeting")
    public String addMeeting(HttpSession session, Model model){
        if(session.getAttribute("username")==null){
            return "redirect:/auth";
        }
        model.addAttribute("role", session.getAttribute("role"));
        model.addAttribute("username", session.getAttribute("username"));

        return "addmeeting";
    }
    @PostMapping("/addmeeting")
    public String addMeeting(@RequestParam Date date, @RequestParam String description, @RequestParam String meetingName,
                             HttpSession session){
        Meeting meeting = new Meeting();

        String username = (String) session.getAttribute("username");

        meeting.setDate(date);
        meeting.setName(meetingName);
        meeting.setDescription(description);
        meeting.setOwner(username);
        meeting.setParticipant_id(userRepository.findUserByUsername(username).get().getId());

        meetingRepository.save(meeting);

        return "redirect:/secured/meetings";
    }
}
