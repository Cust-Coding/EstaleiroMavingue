package com.custcoding.estaleiromavingue.App.models;

import jakarta.persistence.*;

@Entity
@Table(name = "zonas")
public class Zona {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "id_ferragem", nullable = false)
    private Ferragem ferragem;
}
