package com.custcoding.estaleiromavingue.App.dtos.user;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDTO(

        @NotBlank(message = "username can't be blank")
        String username,

        @NotBlank(message = "Please provide a password")
        String password

) {
}
