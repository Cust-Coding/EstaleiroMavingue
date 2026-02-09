package com.custcoding.estaleiromavingue.App.models;


import jakarta.persistence.*;

@Entity
public class Ferragem {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(
            nullable = false,
            unique = true
    )
    private String name;

}
