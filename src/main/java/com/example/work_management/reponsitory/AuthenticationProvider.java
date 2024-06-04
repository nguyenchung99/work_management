package com.example.work_management.reponsitory;

import com.example.work_management.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface AuthenticationProvider {
    User authenticate(String username, String password) throws Exception;
}
