package com.example.bootstickverwaltung.dto;

import com.example.bootstickverwaltung.model.StickGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class USBStickDTO {
    private String inventarnummer;

    private StickGroup group;

    private String typ;            // Bootstick oder Datenstick
    private String speicherkapazitaet; // Größe des Speichers
    private String hersteller;     // Hersteller des USB-Sticks
    private String modell;         // Modellbezeichnung
    private String seriennummer;   // Seriennummer für Garantieansprüche
    private String verfuegbarkeit; // verfügbar, ausgeliehen, reserviert, in Wartung
    private String zustand;        // neu, gebraucht, defekt

}
