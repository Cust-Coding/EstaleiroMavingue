package com.custcoding.estaleiromavingue.App.models;

import jakarta.persistence.*;


@Table(name = "table_users")
@Entity

public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(
            nullable = false,
            length = 255,
            unique = true
    )
    private String username;

    @Column(
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            nullable = false
    )
    private String password;
    @Column(
            nullable = false
    )
    private String password2;




}
