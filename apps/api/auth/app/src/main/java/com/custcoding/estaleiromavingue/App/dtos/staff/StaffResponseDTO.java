package com.custcoding.estaleiromavingue.App.dtos.staff;

import com.custcoding.estaleiromavingue.App.models.status.StaffRoles;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record StaffResponseDTO(
        Long id,
        String name,
        StaffRoles role,
        String phone,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime created,
        Long ferragemId,
        String ferragemName


) {
}
