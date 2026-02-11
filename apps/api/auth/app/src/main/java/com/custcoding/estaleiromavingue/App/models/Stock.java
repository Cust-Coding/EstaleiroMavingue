package com.custcoding.estaleiromavingue.App.models;

import jakarta.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantidade;

    @Column(name = "stock_minimo", nullable = false)
    private int stockMinimo;

    
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Product produto;

    
     @ManyToOne
    @JoinColumn(name = "id_ferragem", nullable = false)
    private Ferragem ferragem;

}
