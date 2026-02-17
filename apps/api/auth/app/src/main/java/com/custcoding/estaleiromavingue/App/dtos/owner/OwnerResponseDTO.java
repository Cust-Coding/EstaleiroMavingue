package com.custcoding.estaleiromavingue.App.dtos.owner;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record OwnerResponseDTO(
    Long id,
    String name,
    String phone,
    String email,
    String nuit,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime created
){
}
