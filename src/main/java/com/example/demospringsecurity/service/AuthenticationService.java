package com.example.demospringsecurity.service;

import com.example.demospringsecurity.dto.LoginDTO;
import com.example.demospringsecurity.dto.RegisterDTO;

public interface AuthenticationService {
    boolean login(LoginDTO loginDTO);

    boolean register(RegisterDTO registerDTO);
}
