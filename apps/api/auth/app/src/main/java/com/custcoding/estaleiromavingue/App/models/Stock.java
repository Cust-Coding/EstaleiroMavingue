package com.custcoding.estaleiromavingue.App.models;

import jakarta.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "stock_minimo", nullable = false)
    private Integer stockMinimo;
    
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Product produto;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ferragem", nullable = false)
    private Ferragem ferragem;

}
