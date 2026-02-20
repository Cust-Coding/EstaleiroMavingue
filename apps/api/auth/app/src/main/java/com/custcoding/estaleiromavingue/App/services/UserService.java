package com.custcoding.estaleiromavingue.App.services;


import com.custcoding.estaleiromavingue.App.dtos.user.UserCreateDTO;
import com.custcoding.estaleiromavingue.App.dtos.user.UserLoginDTO;
import com.custcoding.estaleiromavingue.App.dtos.user.UserResponseDTO;
import com.custcoding.estaleiromavingue.App.models.User;
import com.custcoding.estaleiromavingue.App.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final AuthenticationManager authenticationManager;


    private final UserRepository userRepository;

    public Authentication authenticate(
            UserLoginDTO data
    ){
        var usernamePassoword = new UsernamePasswordAuthenticationToken(
                data.username(), data.password()
        );

        return this.authenticationManager.authenticate(usernamePassoword);
    }

    public UserResponseDTO register(
            UserCreateDTO data
    ){
        if(userRepository.existsByUsername(data.username())){
            throw new UsernameAl
        }
        var user = new User();
    }




}
