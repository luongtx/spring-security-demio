package com.example.demospringsecurity.dto;

import com.example.demospringsecurity.constants.ValidationConstant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTO {

    @NotBlank(message = ValidationConstant.REQUIRED_USERNAME)
    private String username;

    @NotBlank(message = ValidationConstant.REQUIRED_PASSWORD)
    private String password;
}
