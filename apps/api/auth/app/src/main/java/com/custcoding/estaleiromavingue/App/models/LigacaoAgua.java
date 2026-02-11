package com.custcoding.estaleiromavingue.App.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ligacoes_agua")
public class LigacaoAgua {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoLigacao estado;

    
    @ManyToOne
    @JoinColumn(name = "id_consumidor", nullable = false)
    private ConsumidorAgua consumidor;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private Funcionario funcionario;
}
