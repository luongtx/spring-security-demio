package com.example.demospringsecurity.service.impl;

import com.example.demospringsecurity.constants.ApplicationMessageConstant;
import com.example.demospringsecurity.dto.ProfileDTO;
import com.example.demospringsecurity.entity.Profile;
import com.example.demospringsecurity.exception.AppUserException;
import com.example.demospringsecurity.repo.ProfileRepo;
import com.example.demospringsecurity.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    ProfileRepo profileRepo;

    @Override
    public ProfileDTO getProfileByUserId(Long userId) {
        Profile profile = profileRepo.findByUserId(userId);
        log.info(profile.toString());
        return convertToProfileDTO(profile);
    }

    @Override
    public String updateProfile(Long userId, ProfileDTO profileDTO) throws AppUserException{
        try {
            Profile profile = profileRepo.findByUserId(userId);
            profile.setEmail(profileDTO.getEmail());
            profile.setFullName(profileDTO.getFullName());
            profile.setGender(profileDTO.getGender());
            profile.setPhoneNo(profileDTO.getPhoneNo());
            profile.setBirthDay(profileDTO.getBirthDay());
            profileRepo.save(profile);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new AppUserException(e.getMessage());
        }
        return ApplicationMessageConstant.SUCCESSFULLY_UPDATE_PROFILE;
    }

    ProfileDTO convertToProfileDTO(Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setEmail(profile.getEmail());
        profileDTO.setFullName(profile.getFullName());
        profileDTO.setGender(profile.getGender());
        profileDTO.setPhoneNo(profile.getPhoneNo());
        profileDTO.setBirthDay(profile.getBirthDay());
        return profileDTO;
    }
}
