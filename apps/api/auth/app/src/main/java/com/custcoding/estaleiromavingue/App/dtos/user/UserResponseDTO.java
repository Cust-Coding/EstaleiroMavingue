package com.custcoding.estaleiromavingue.App.dtos.user;

import com.custcoding.estaleiromavingue.App.models.status.Roles;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UserResponseDTO(
        String id,
        String username,
        Roles role,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime created
) {
}
