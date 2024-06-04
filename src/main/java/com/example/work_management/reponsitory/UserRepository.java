package com.example.work_management.reponsitory;

import com.example.work_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByUsername(String username);
    Boolean existsAllByUsername(String username);
    Boolean existsAllByEmail(String email);

}
