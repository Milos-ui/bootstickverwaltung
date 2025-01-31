package com.example.bootstickverwaltung.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usb_stick") // Name der Datenbank-Tabelle
public class USBStick {

    @Setter
    @Getter
    @Id
    private String inventarnummer;      // Eindeutige Inventarnummer

    @Setter
    @Getter
    private String typ;                 // Bootstick oder Datenstick

    @Setter
    @Getter
    private String speicherkapazitaet;  // Größe des Speichers (z.B. "16GB")

    @Setter
    @Getter
    private String hersteller;          // Hersteller

    @Setter
    @Getter
    private String modell;              // Modellbezeichnung

    @Setter
    @Getter
    private String seriennummer;        // Seriennummer

    @Setter
    @Getter
    private String verfuegbarkeit;      // z.B. verfügbar, ausgeliehen, reserviert, in Wartung

    @Setter
    @Getter
    private String zustand;             // neu, gebraucht, defekt

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "group_id")      // Verweis auf StickGroup (FK-Spalte in DB)
    @JsonBackReference
    private StickGroup group;

    // Standard-Konstruktor (erforderlich für JPA)
    public USBStick() {
    }

}
