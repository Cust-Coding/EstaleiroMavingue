package com.custcoding.estaleiromavingue.App.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "leituras_agua")
public class LeituraAgua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(name = "leitura_anterior", nullable = false)
    private double leituraAnterior;

    @Column(name = "leitura_actual", nullable = false)
    private double leituraActual;
    
     @Column(name = "valor_pagar", nullable = false)
    private double valorPagar;

    
    @ManyToOne
    @JoinColumn(name = "id_ligacao", nullable = false)
    private LigacaoAgua ligacao;
}
