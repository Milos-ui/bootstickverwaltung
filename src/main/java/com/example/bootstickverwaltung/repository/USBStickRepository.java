package com.example.bootstickverwaltung.repository;

import com.example.bootstickverwaltung.model.USBStick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface USBStickRepository extends JpaRepository<USBStick, String> {
}
