package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User register(User user) {

        return repository.save(user);

    }


    public User login(String email, String password) {

        User user = repository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {

            return user;

        }

        return null;

    }


    public List<User> getAllUsers() {

        return repository.findAll();

    }

}