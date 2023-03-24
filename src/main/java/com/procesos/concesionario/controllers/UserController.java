package com.procesos.concesionario.controllers;


import com.procesos.concesionario.models.User;
import com.procesos.concesionario.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") Long id){

        Map response = new HashMap<>();

        try{
            response.put("message"," Se encontro el usuario");
            response.put("data",userService.getUserById(id) );
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e) {
            response.put("message"," No Se encontro el usuario");
            response.put("data",e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/")
    public ResponseEntity getAllUsers(){

        Map response = new LinkedHashMap();

        try{
            response.put("data",userService.getAllUsers());
            response.put("message"," Usuarios listados");
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e) {
            response.put("message"," No Se Listaron Los Usuarios");
            response.put("data",e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = "/")
    public ResponseEntity createUser(@RequestBody User user){
        Map response = new HashMap<>();

        try{
            response.put("message","Se guardo el usuario");
            response.put("data",userService.createUser(user));
            return new ResponseEntity(response, HttpStatus.CREATED);
        }catch (Exception e) {
            response.put("message","No Se guardo el usuario");
            response.put("data",e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping (value = "/{id}")
    public ResponseEntity updateUser(@PathVariable(name = "id") Long id, @RequestBody User user){
        Map response = new HashMap<>();

        try{
            response.put("message","Se Actualizo El Usuario");
            response.put("data",userService.updateUser(id, user));
            return new ResponseEntity(response, HttpStatus.CREATED);
        }catch (Exception e) {
            response.put("message","No Se Pudo Actualizar");
            response.put("data",e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
}
