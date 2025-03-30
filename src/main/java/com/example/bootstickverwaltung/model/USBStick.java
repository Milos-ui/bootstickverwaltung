package com.example.bootstickverwaltung.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usb_stick") // Name der Datenbank-Tabelle
@Getter @Setter
@NoArgsConstructor
public class USBStick {

    @Id
    private String inventarnummer;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private StickGroup group;

    private String typ;            // Bootstick oder Datenstick
    private String speicherkapazitaet; // Größe des Speichers
    private String hersteller;     // Hersteller des USB-Sticks
    private String modell;         // Modellbezeichnung
    private String seriennummer;   // Seriennummer für Garantieansprüche
    private String verfuegbarkeit; // verfügbar, ausgeliehen, reserviert, in Wartung
    private String zustand;        // neu, gebraucht, defekt

}
