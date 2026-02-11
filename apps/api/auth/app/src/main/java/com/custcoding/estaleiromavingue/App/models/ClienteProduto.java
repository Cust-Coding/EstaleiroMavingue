package com.custcoding.estaleiromavingue.App.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "ClienteProduto")
public class ClienteProduto {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column( length = 20)
    private String telefone;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;
}
