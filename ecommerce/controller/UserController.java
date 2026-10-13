package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.model.User;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userService.register(user);

    }


    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return userService.login(user.getEmail(), user.getPassword());

    }


    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();

    }

}