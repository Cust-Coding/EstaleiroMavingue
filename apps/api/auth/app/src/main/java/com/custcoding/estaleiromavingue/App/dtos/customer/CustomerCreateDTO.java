package com.custcoding.estaleiromavingue.App.dtos.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CustomerCreateDTO(
        @NotEmpty
        @NotBlank
        @NotNull
        String nome,

        @NotNull
        @NotEmpty
        @NotBlank
        String telefone,


        @Email
        String email
) {
}
