package com.example.demospringsecurity.webctrl;

import com.example.demospringsecurity.dto.LoginDTO;
import com.example.demospringsecurity.dto.RegisterDTO;
import com.example.demospringsecurity.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthWebController {

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/user")
    public String getUser() {
        return "user";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

    @PostMapping("/login")
    public boolean login(@Valid @RequestBody LoginDTO loginDTO) {
        return authenticationService.login(loginDTO);
    }

    @PostMapping("/register")
    public boolean register(@Valid @RequestBody RegisterDTO registerDTO) {
        return authenticationService.register(registerDTO);
    }
}
