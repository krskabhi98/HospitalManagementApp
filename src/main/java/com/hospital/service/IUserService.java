package com.hospital.service;

import com.hospital.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {

    User addNewUser(User newUser);

    List<User> getAllUserDetails();
}
