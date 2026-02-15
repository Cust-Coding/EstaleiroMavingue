package com.custcoding.estaleiromavingue.App.dtos.customer;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record CustomerResponseDTO (
    Long id,
    String name,
    String phone,
    String email,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime created
){
}
