package com.custcoding.estaleiromavingue.App.repositories;


import com.custcoding.estaleiromavingue.App.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
