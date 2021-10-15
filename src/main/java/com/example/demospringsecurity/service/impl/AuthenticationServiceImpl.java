package com.example.demospringsecurity.service.impl;

import com.example.demospringsecurity.dto.LoginDTO;
import com.example.demospringsecurity.dto.RegisterDTO;
import com.example.demospringsecurity.entity.Profile;
import com.example.demospringsecurity.entity.User;
import com.example.demospringsecurity.repo.ProfileRepo;
import com.example.demospringsecurity.repo.UserRepo;
import com.example.demospringsecurity.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean login(LoginDTO loginDTO) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getUsername());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, loginDTO.getPassword(),
                userDetails.getAuthorities());
        authenticationManager.authenticate(token);
        boolean result = token.isAuthenticated();
        if (result) {
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        return result;
    }

    @Override
    @Transactional
    public boolean register(RegisterDTO registerDTO) {
        try {
            User user = new User();
            user.setUsername(registerDTO.getUsername());
            user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
            User savedUser = userRepo.save(user);
            Profile profile = constructProfile(registerDTO, savedUser);
            profileRepo.save(profile);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    Profile constructProfile(RegisterDTO registerDTO, User user) {
        Profile profile = new Profile();
        profile.setEmail(registerDTO.getEmail());
        profile.setFullName(registerDTO.getFullName());
        profile.setGender(registerDTO.getGender());
        profile.setBirthDay(registerDTO.getBirthDay());
        profile.setPhoneNo(registerDTO.getPhoneNo());
        profile.setUser(user);
        return profile;
    }
}
