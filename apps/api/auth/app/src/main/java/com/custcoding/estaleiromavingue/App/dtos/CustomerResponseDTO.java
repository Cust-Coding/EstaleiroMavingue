package com.custcoding.estaleiromavingue.App.dtos;

import java.time.LocalDateTime;

public record CustomerResponseDTO (
    Long id,
    String nome,
    String telefone,
    String email,
    LocalDateTime dataCriacao
){
}
