package com.example.work_management.model;

import lombok.Data;

@Data
public class TaskDto {
    private String name;
    private String status;
    private String description;
    private Long userId;
}
