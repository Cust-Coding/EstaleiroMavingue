package com.custcoding.estaleiromavingue.App.services;


import com.custcoding.estaleiromavingue.App.dtos.user.UserCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.user.UserLoginDTO;
import com.custcoding.estaleiromavingue.App.dtos.user.UserResponseDTO;
import com.custcoding.estaleiromavingue.App.exception.UsernameAlreadyExistsException;

import com.custcoding.estaleiromavingue.App.models.User;
import com.custcoding.estaleiromavingue.App.repositories.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public Authentication authenticate(
            UserLoginDTO data
    ){
        var usernamePassoword = new UsernamePasswordAuthenticationToken(
                data.username(), data.password()
        );

        return this.authenticationManager.authenticate(usernamePassoword);
    }

    public UserResponseDTO register(UserCreateDTO data){

        if (userRepository.existsByUsername(data.username())){
            throw new UsernameAlreadyExistsException(data.username());
        }

        String password = passwordEncoder.encode(data.password());

        User user = new User();
        user.setUsername(data.username());
        user.setPassword(password);
        user.setRole(data.role());


        var savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getPassword(),
                savedUser.getRole(),
                savedUser.getCreated()
        );

    }




}
