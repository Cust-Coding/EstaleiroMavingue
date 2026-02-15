package com.custcoding.estaleiromavingue.App.dtos.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CustomerCreateDTO(
        @NotBlank(message = "Name cannot be blank")
        @JsonProperty("name")
        String name,

        @NotBlank(message = "Phone cannot be blank")
        @JsonProperty("phone")
        String phone,

        @Email
        @JsonProperty("email")
        @NotNull
        String email
) {
}
