package com.example.demospringsecurity.webctrl;

import com.example.demospringsecurity.dto.LoginDTO;
import com.example.demospringsecurity.dto.ProfileDTO;
import com.example.demospringsecurity.dto.RegisterDTO;
import com.example.demospringsecurity.exception.AppUserException;
import com.example.demospringsecurity.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthWebController {

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping({"/", "/home"})
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
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO) throws AppUserException {
        String result = authenticationService.login(loginDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO registerDTO) throws AppUserException {
        String result = authenticationService.register(registerDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
