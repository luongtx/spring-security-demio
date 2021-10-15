package com.example.demospringsecurity.service;

import com.example.demospringsecurity.dto.LoginDTO;
import com.example.demospringsecurity.dto.RegisterDTO;
import com.example.demospringsecurity.exception.AppUserException;
import org.springframework.security.authentication.BadCredentialsException;

public interface AuthenticationService {
    String login(LoginDTO loginDTO) throws AppUserException;

    String register(RegisterDTO registerDTO) throws AppUserException;
}
