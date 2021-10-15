package com.example.demospringsecurity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RegisterDTO {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;
    private String fullName;
    private String gender;
    private String email;
    private String phoneNo;
    //Json Date value cannot be deserialized without this annotation
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDay;

}
