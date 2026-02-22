package com.custcoding.estaleiromavingue.App.dtos.staff;

import com.custcoding.estaleiromavingue.App.models.Ferragem;
import com.custcoding.estaleiromavingue.App.models.status.StaffRoles;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record StaffCreateDTO(

        @NotBlank(message = "name can't be blank")
        String name,
        @NotNull(message = "provide the staff role")
        StaffRoles role,
        @NotBlank(message = "provide the staff phone number")
        String phone,
        @NotNull(message = "provide a ferragem id")
        Long ferragemId
) {
}
