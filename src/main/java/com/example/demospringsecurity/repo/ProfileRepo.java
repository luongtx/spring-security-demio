package com.example.demospringsecurity.repo;

import com.example.demospringsecurity.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
}
