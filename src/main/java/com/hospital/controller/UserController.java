package com.hospital.controller;

import com.hospital.model.User;
import com.hospital.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addNewUser(
            @RequestBody User newUser
            ){
        User addedUser=userService.addNewUser(newUser);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);

    }
}
