package com.custcoding.estaleiromavingue.App.models;

import com.custcoding.estaleiromavingue.App.models.status.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "table_users")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(
            nullable = false,
            unique = true,
            length = 100
    )
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Roles role;

    @Column(nullable = false)

    private Boolean is_active = true;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime created;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == Roles.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        }
        else{
            return List.of( new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
