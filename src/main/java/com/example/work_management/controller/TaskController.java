package com.example.work_management.controller;

import com.example.work_management.entity.Task;
import com.example.work_management.response.ResponseBase;
import com.example.work_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/get")
    public ResponseBase getTaskByUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return taskService.getTaskByUsername(username);
    }

    @PostMapping("/create")
    public ResponseBase create(@RequestBody Task task){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return taskService.create(task, username);
    }

    @PostMapping("/update")
    public ResponseBase update(@RequestBody Task task){
        return taskService.update(task);
    }

    @PostMapping("/delete")
    public ResponseBase delete(@RequestBody List<Long> ids){
        return taskService.deleteByIds(ids);
    }
}
