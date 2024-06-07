package com.example.work_management.service;

import com.example.work_management.entity.LoginHistory;
import com.example.work_management.entity.User;
import com.example.work_management.entity.UserRoles;
import com.example.work_management.model.LoginHistorySearch;
import com.example.work_management.reponsitory.LoginHistoryRepository;
import com.example.work_management.response.ResponseBase;
import com.example.work_management.response.ResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginHistoryService {
    @Autowired
    LoginHistoryRepository repository;

    @Autowired
    UserRoleService userRoleService;

    public ResponsePage<LoginHistory> search(LoginHistorySearch loginHistorySearch){
        Pageable pageable = PageRequest.of(loginHistorySearch.getPage(), loginHistorySearch.getLimit(), Sort.by("created"));
        Page<LoginHistory> page = this.repository.search(loginHistorySearch.getUsename(),loginHistorySearch.getType(),
                loginHistorySearch.getFromDate(), loginHistorySearch.getToDate(), pageable);
        ResponsePage<LoginHistory> responsePage = new ResponsePage<>();
        responsePage.setBody(page.getContent());
        responsePage.setTotalElements(page.getTotalElements());
        return responsePage;
    }

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
