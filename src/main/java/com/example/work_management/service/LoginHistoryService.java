package com.example.work_management.service;

import com.example.work_management.entity.LoginHistory;
import com.example.work_management.entity.User;
import com.example.work_management.entity.UserRoles;
import com.example.work_management.reponsitory.LoginHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginHistoryService {
    @Autowired
    LoginHistoryRepository repository;

    @Autowired
    UserRoleService userRoleService;

    public void create(User user){
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setUsername(user.getUsername());
        List<UserRoles> userRolesList = userRoleService.findByUser(user);
        String type = userRolesList.stream().map(userRoles ->
                userRoles.getRoleId().getName().split("_")[1]).collect(Collectors.joining(","));
        loginHistory.setType(type);
        this.repository.save(loginHistory);
    }
}
