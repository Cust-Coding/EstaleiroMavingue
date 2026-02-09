package com.custcoding.estaleiromavingue.App.models;


import jakarta.persistence.*;

@Entity
public class FM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            unique = true
    )
    private String phone;

    @Column(
            unique = true
    )
    private String email;

}
