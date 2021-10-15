package com.example.demospringsecurity.webctrl;

import com.example.demospringsecurity.dto.ProfileDTO;
import com.example.demospringsecurity.exception.AppUserException;
import com.example.demospringsecurity.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserWebController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/{id}/profile")
    public ResponseEntity<ProfileDTO> getUserProfile(@PathVariable("id") Long userId) {
        ProfileDTO profileDTO = userProfileService.getProfileByUserId(userId);
        return new ResponseEntity<>(profileDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}/profile/update")
    public ResponseEntity<String> updateUserProfile(@PathVariable("id") Long userId,
                                                    @Valid @RequestBody ProfileDTO profileDTO) throws AppUserException {
        String result = userProfileService.updateProfile(userId, profileDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
