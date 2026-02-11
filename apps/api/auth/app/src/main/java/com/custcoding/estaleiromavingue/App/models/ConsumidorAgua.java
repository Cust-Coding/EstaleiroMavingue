package com.custcoding.estaleiromavingue.App.models;
import jakarta.persistence.*;

@Entity
@Table(name = "consumidores_agua")
public class ConsumidorAgua {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(name = "nr_casa", nullable = false, length = 20)
    private String nrCasa;

    @Column(name = "palavra_passe", nullable = false)
    private String palavraPasse;
    
    @ManyToOne
    @JoinColumn(name = "id_zona", nullable = false)
    private Zona zona;
  
}
