package com.custcoding.estaleiromavingue.App.models;

import jakarta.persistence.*;
@Entity
@Table(name = "proprietario")
public class Proprietario {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 20)
    private String telefone;
    
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, unique = true, length = 20)
    private String nuit;

    @Column(name = "palavra_passe", nullable = false)
    private String palavraPasse;
    
}
