package com.example.work_management.service;

import com.example.work_management.entity.User;
import com.example.work_management.entity.UserRoles;
import com.example.work_management.reponsitory.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    public List<UserRoles> findByUser(User user){
        return userRoleRepository.findByUserId(user);
    }
}
