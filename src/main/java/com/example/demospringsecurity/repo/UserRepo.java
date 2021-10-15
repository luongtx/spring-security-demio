package com.example.demospringsecurity.repo;

import com.example.demospringsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
