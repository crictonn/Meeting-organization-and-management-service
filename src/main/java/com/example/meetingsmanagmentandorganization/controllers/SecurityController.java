package com.example.meetingsmanagmentandorganization.controllers;

import com.example.meetingsmanagmentandorganization.controllers.reqeust.SigninRequest;
import com.example.meetingsmanagmentandorganization.controllers.reqeust.SignupRequest;
import com.example.meetingsmanagmentandorganization.jwt.JwtCore;
import com.example.meetingsmanagmentandorganization.model.User;
import com.example.meetingsmanagmentandorganization.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class SecurityController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtCore jwtCore;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @GetMapping()
    public String lobby(){
        return "lobby";
    }

    @Autowired
    public void setJwtCore(JwtCore jwtCore) {
        this.jwtCore = jwtCore;
    }

    @PostMapping("/signup")
//    ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest){
    public String signup(@RequestParam String username, @RequestParam String email, @RequestParam String password){
        if(userRepository.existsUserByUsername(username)){
            return "/signup";
        }
        if(userRepository.existsUserByEmail(email)){
            return "/signup";
        }

        User user = new User();

        String hashed = passwordEncoder.encode(password);

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashed);
        if("admin".equalsIgnoreCase(username))
            user.setRole("ADMIN");
        else
            user.setRole("USER");
        userRepository.save(user);

//        return ResponseEntity.ok("Signup success");
        return "redirect:/auth/signin";
    }
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signin")
//    ResponseEntity<?> signin(@RequestBody SigninRequest signinRequest){
    public String signin(@RequestParam String username, @RequestParam String password, HttpSession session){
        Authentication authentication = null;
        try{
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            return "/signin";
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);
        session.setAttribute("username", username);
        User user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                String.format("User '%s' not found", username)
        ));
        session.setAttribute("role", user.getRole());
//        return ResponseEntity.ok(jwt);
        return "redirect:/secured/user";
    }
    @GetMapping("/signin")
    public String signin(){
        return "signin";
    }
}
