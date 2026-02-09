package com.custcoding.estaleiromavingue.App.models;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "table_product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            length = 150
    )
    private String name;

    @Column(
            nullable = false
    )
    private BigDecimal price;


}
