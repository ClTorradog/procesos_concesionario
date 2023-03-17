package com.procesos.concesionario.controllers;


import com.procesos.concesionario.models.User;
import com.procesos.concesionario.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable(name = "id") Long id){
        return userService.getUserById(id);
    }
    @PostMapping(value = "/")
    public User createUser(@RequestBody User user){

        return userService.createUser(user);

    }
}
