package com.custcoding.estaleiromavingue.App.models;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String cargo;

    @Column(nullable = false, length = 20)
    private String telefone;

    
    @ManyToOne
    @JoinColumn(name = "id_ferragem", nullable = false)
    private Ferragem ferragem;
     
    @ManyToOne
    @JoinColumn(name = "id_proprietario", nullable = false)
    private Owner owner;
}
