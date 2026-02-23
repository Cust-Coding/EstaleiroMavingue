package com.custcoding.estaleiromavingue.App.models;

import com.custcoding.estaleiromavingue.App.models.status.StaffRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private StaffRoles role;

    @Column(nullable = false, length = 20)
    private String phone;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, name = "created_date")
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "id_ferragem", nullable = false)
    private Ferragem ferragem;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
