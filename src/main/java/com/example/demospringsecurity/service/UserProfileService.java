package com.example.demospringsecurity.service;

import com.example.demospringsecurity.dto.ProfileDTO;
import com.example.demospringsecurity.exception.AppUserException;

public interface UserProfileService {
    ProfileDTO getProfileByUserId(Long userId);

    String updateProfile(Long userId, ProfileDTO profileDTO) throws AppUserException;
}
