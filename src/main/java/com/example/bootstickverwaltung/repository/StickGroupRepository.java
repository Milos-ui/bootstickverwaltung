package com.example.bootstickverwaltung.repository;

import com.example.bootstickverwaltung.model.StickGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickGroupRepository extends JpaRepository<StickGroup, String> {
    // Standardmethoden wie findAll(), findById(), etc. kommen aus JpaRepository
}
