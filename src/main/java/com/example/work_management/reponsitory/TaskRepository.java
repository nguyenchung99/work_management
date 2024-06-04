package com.example.work_management.reponsitory;

import com.example.work_management.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByUserId(Long userId);
    Task findTaskByName(String taskName);
    Task findTaskById(Long id);
}
