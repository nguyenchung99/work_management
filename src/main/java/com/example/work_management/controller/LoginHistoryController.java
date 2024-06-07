package com.example.work_management.controller;

import com.example.work_management.entity.LoginHistory;
import com.example.work_management.model.LoginHistorySearch;
import com.example.work_management.response.ResponseBase;
import com.example.work_management.response.ResponsePage;
import com.example.work_management.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login-history")
@CrossOrigin(origins = "*")
public class LoginHistoryController {

    @Autowired
    LoginHistoryService loginHistoryService;

    @GetMapping("/search")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR')")
    public ResponsePage<LoginHistory> search(@RequestParam Map<String, String> params){
        LoginHistorySearch loginHistorySearch = new LoginHistorySearch();
        loginHistorySearch.setParam(params);
        return loginHistoryService.search(loginHistorySearch);
    }
}
