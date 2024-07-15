package com.db.hackathon.dementia.dabbler.caringbridge.controller;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.User;
import com.db.hackathon.dementia.dabbler.caringbridge.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/checkIfEmailAlreadyExists/{email}")
    public boolean checkIfEmailAlreadyExists(@PathVariable String email) {
        log.info("email is {}", email);
        return userService.checkIfEmailAlreadyExists(email);
    }

    @GetMapping("/patient/{phoneNumber}")
    public User getPatientByPhoneNumber(@PathVariable String phoneNumber) {
        return userService.findByPhoneNumber(phoneNumber);
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        return userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    @PostMapping("/patient")
    public User updateUser(@RequestBody User user) {
        log.info("User is {} ", user);
        return userService.updateUser(user);
    }
}

