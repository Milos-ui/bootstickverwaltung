package com.example.bootstickverwaltung.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usb_stick")
public class USBStick {

    @Id
    @Column(name = "inventarnummer", nullable = false, unique = true)
    @Getter @Setter
    private String inventarnummer;

    @Getter @Setter
    private String typ;

    @Getter @Setter
    private String speicherkapazitaet;

    @Getter @Setter
    private String hersteller;

    @Getter @Setter
    private String modell;

    @Getter @Setter
    private String seriennummer;

    @Getter @Setter
    private String verfuegbarkeit;

    @Getter @Setter
    private String zustand;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private StickGroup group;

    // Standard-Konstruktor
    public USBStick() {
    }
}
