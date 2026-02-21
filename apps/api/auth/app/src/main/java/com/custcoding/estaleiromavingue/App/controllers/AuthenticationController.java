package com.custcoding.estaleiromavingue.App.controllers;


import com.custcoding.estaleiromavingue.App.dtos.user.LoginResponseDTO;
import com.custcoding.estaleiromavingue.App.dtos.user.UserLoginDTO;
import com.custcoding.estaleiromavingue.App.dtos.user.UserCreateDTO;
import com.custcoding.estaleiromavingue.App.infra.security.service.TokenService;
import com.custcoding.estaleiromavingue.App.models.User;
import com.custcoding.estaleiromavingue.App.repositories.UserRepository;
import com.custcoding.estaleiromavingue.App.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserService userService;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(
            @Valid @RequestBody UserLoginDTO data
    ){
        var auth = userService.authenticate(data);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity register(
            @Valid @RequestBody UserCreateDTO userData
    ){

        var newUser = userService.register(userData);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
    }

}
