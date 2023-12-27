package com.hospital.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.api.impl.rest.response.IActionStatusNanager;
import com.hospital.api.impl.rest.response.IServiceResponse;
import com.hospital.api.impl.rest.response.ServiceResponse;
import com.hospital.api.impl.rest.response.Status;
import com.hospital.business.domain.ActionStatus;
import com.hospital.business.domain.ActionStatusType;
import com.hospital.model.User;
import com.hospital.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static com.hospital.constant.HospitalManagementURIConst.ADD_NEW_USER;

@RestController
public class UserController {

    private static final Logger LOG= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    IActionStatusNanager actionStatusNanager;

    @PostMapping(value = ADD_NEW_USER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ReqValidator
//    @Operation
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<String> addNewUser(@RequestBody User newUser) throws Exception {

        IServiceResponse<Status> serviceResponse;
        Instant managerCallTime=Instant.now();
        try{
            User addedUser = userService.addNewUser(newUser);

            serviceResponse=buildResponse(String.valueOf("123"), ActionStatusType.SUCCESS);
            return new ResponseEntity<>(objectMapper.writeValueAsString(serviceResponse), HttpStatus.CREATED);
        }
        catch (JsonProcessingException ex){
            LOG.error(String.valueOf(ex));
//            throw actionStatusNanager.getReportableException(ActionStatusType.INVALID_INPUT_RECEIVED);
           throw new Exception(ex);
        }
    }

    private ServiceResponse buildResponse(String ID, ActionStatusType status) {
        ServiceResponse serviceResponse=new ServiceResponse();
        serviceResponse.setId(ID);
        serviceResponse.setStatus(buildResponseList(status));
        return serviceResponse;
    }

    private List<Status> buildResponseList(ActionStatusType actionStatusType) {
        List<Status> responseStatus =new ArrayList<>(10);
        ActionStatus actionStatus=actionStatusNanager.getActionStatus(actionStatusType.getMajor(),actionStatusType.getMinor());
        responseStatus.add(new Status(actionStatus.getMajor().toString(), actionStatus.getMinor().toString(),
                actionStatus.getLevel().toString(), actionStatus.getMessage()));
        return responseStatus;
    }

    @GetMapping("/getUsers")
    public List<User> getAllUserDetails() {
        List<User> user = userService.getAllUserDetails();
        return user;
    }
}
