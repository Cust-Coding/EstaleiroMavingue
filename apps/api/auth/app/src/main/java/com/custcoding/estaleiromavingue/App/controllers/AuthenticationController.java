package com.custcoding.estaleiromavingue.App.controllers;


import com.custcoding.estaleiromavingue.App.dtos.user.UserLoginDTO;
import com.custcoding.estaleiromavingue.App.dtos.user.UserCreateDTO;
import com.custcoding.estaleiromavingue.App.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(
            @Valid @RequestBody UserLoginDTO data
    ){
        var auth = userService.authenticate(data);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/register")
    public ResponseEntity register(
            @Valid @RequestBody UserCreateDTO userData
    ){



    }

}
