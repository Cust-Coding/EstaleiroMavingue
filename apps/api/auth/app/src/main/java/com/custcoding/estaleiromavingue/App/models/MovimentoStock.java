package com.custcoding.estaleiromavingue.App.models;

import com.custcoding.estaleiromavingue.App.models.status.TipoMovimento;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimento_stock")
public class MovimentoStock {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimento tipo;

    @Column(nullable = false)
    private int quantidade;
     @Column(name = "data_movimento", nullable = false)
    private LocalDateTime dataMovimento;

   
    @ManyToOne
    @JoinColumn(name = "id_stock", nullable = false)
    private Stock stock;
    
}
