package com.hospital.service.serviceImpl;

import com.hospital.model.User;
import com.hospital.repository.IUserRepository;
import com.hospital.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService   {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User addNewUser(User newUser) {
        return userRepository.save(newUser);
    }
}
