package com.custcoding.estaleiromavingue.App.models;

import com.custcoding.estaleiromavingue.App.models.status.FormaPagamento;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "factura_compra")
public class FacturaCompra {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(name = "data_emissao", nullable = false)
    private LocalDateTime dataEmissao;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Product produto;

    @Column(nullable = false)
    private int quantidade; 

     @Column(name = "preco_unitario", nullable = false)
    private double precoUnitario;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false)
    private FormaPagamento formaPagamento;
}
