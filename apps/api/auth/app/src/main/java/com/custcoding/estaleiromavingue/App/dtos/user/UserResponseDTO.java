package com.custcoding.estaleiromavingue.App.dtos.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UserResponseDTO(
        String id,
        String username,
        String password,
        String role,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime created
) {
}
