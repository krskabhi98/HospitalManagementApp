package com.hospital.controller;

import com.hospital.model.User;
import com.hospital.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.hospital.constant.HospitalManagementURIConst.ADD_NEW_USER;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = ADD_NEW_USER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ReqValidator
    @Operation
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<User> addNewUser(@RequestBody User newUser) {
        User addedUser = userService.addNewUser(newUser);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);

    }

    @GetMapping("/getUsers")
    public List<User> getAllUserDetails() {
        List<User> user = userService.getAllUserDetails();
        return user;
    }
}
