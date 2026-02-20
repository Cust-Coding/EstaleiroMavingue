package com.custcoding.estaleiromavingue.App.dtos.user;

import com.custcoding.estaleiromavingue.App.models.status.Roles;
import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(

        @NotBlank(message = "username can't be blank")
        String username,
        @NotBlank(message = "provide a password")
        String password,

        Roles role

) {
}
