package com.custcoding.estaleiromavingue.App.dtos.customer_water;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record CustomerWaterResponseDTO(
        Long id,
        String name,
        String phone,
        String email,
        String houseNR,
        String adressName,
        String bairro,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime created
) {
}
