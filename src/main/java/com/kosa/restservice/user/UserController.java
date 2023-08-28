package com.kosa.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;
    @GetMapping("/users")
    public List<User> allUsers(){
        return service.findAll();
    }

    @PostMapping("/users")
    public String addUser(){
        return "ADD USER";
    }

    @GetMapping("/users/{id}")
    public User oneUser(@PathVariable int id){
        return service.findOne(id);
    }

    @DeleteMapping("/users/{id}")
    public String delUser(@PathVariable int id){
        return id+"USER DELETE";
    }
}
