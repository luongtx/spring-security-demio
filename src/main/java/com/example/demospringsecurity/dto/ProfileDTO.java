package com.example.demospringsecurity.dto;

import com.example.demospringsecurity.constants.ValidationConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {

    @NotBlank(message = ValidationConstant.REQUIRED_FULL_NAME)
    private String fullName;

    private String gender;

    private String email;

    private String phoneNo;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDay;

}
