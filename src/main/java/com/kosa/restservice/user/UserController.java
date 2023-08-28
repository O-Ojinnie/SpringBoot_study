package com.kosa.restservice.user;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService service;
    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @PostMapping("/users")
    public String createUser(){
        return "ADD USER";
    }

    @GetMapping("/users/{id}")
    public User retrieveOneUser(@PathVariable int id){
        return service.findOne(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        return id+"USER DELETE";
    }
}
