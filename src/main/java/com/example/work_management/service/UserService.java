package com.example.work_management.service;

import com.example.work_management.entity.User;
import com.example.work_management.reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUserByUsername(String username){
        return this.userRepository.findAllByUsername(username);
    }
}
