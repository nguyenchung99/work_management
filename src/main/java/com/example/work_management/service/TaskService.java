package com.example.work_management.service;

import com.example.work_management.entity.Task;
import com.example.work_management.entity.User;
import com.example.work_management.reponsitory.TaskRepository;
import com.example.work_management.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserService userService;

    public ResponseBase getTaskByUsername(String username){
        List<Task> tasks;
        try{
            User user = userService.findUserByUsername(username);
            tasks = taskRepository.findTaskByUserId(user.getId());
        }catch (Exception e){
            return ResponseBase.getInternalServerError();
        }
        return ResponseBase.getSuccess(tasks);
    }

    public ResponseBase create(Task task, String username){
        Task taskRes = new Task();
        try {
            User user = userService.findUserByUsername(username);
            if (!checkDuplicateTaskName(task.getName())) {
                task.setUserId(user.getId());
                taskRes = taskRepository.save(task);
            }else return ResponseBase.getDuplicateError();
        }catch (Exception e){
            return ResponseBase.getInternalServerError();
        }
        return ResponseBase.getSuccess(taskRes);
    }

    public ResponseBase update(Task task){
        Task taskRes = new Task();
        try {
            if (!checkDuplicateTaskName(task.getName())) {
                Task taskDb = taskRepository.findTaskById(task.getId());
                if (Objects.nonNull(taskDb)) {
                    taskDb.setName(task.getName());
                    taskDb.setStatus(task.getStatus());
                    taskDb.setUserId(task.getUserId());
                    taskDb.setDescription(task.getDescription());
                    taskRes = taskRepository.save(taskDb);
                } else ResponseBase.getInternalServerError();
            }else return ResponseBase.getDuplicateError();
        }catch (Exception e){
            return ResponseBase.getInternalServerError();
        }
        return ResponseBase.getSuccess(taskRes);
    }

    public ResponseBase deleteByIds(List<Long> ids){
        try {
            taskRepository.deleteAllById(ids);
        }catch (Exception e){
            return ResponseBase.getInternalServerError();
        }
        return ResponseBase.getSuccess(null);
    }

    private Boolean checkDuplicateTaskName(String taskName){
        Task task = taskRepository.findTaskByName(taskName);
        return Objects.nonNull(task);
    }
}
