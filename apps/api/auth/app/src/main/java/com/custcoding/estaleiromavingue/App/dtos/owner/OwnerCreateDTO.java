package com.custcoding.estaleiromavingue.App.dtos.owner;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OwnerCreateDTO(
        @NotBlank(message = "Name should not be blank")
        String name,
        @NotBlank(message = "Phone should not be blank")
        String phone,
        @Email
        @NotNull(message = "Please provide an email")
        String email,
        @NotBlank(message = "Nuit should not be blank")
        String nuit
) {
}
