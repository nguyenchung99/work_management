package com.example.work_management.reponsitory;

import com.example.work_management.entity.User;
import com.example.work_management.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, Long> {
    List<UserRoles> findByUserId(User userId);
}
