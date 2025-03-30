package com.example.bootstickverwaltung.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class USBStickDTO {

    private String inventarnummer;
    private String groupId;            // Nur ID der Gruppe, statt ganzem StickGroup-Objekt

    private String typ;                // Bootstick oder Datenstick
    private String speicherkapazitaet; // Größe des Speichers
    private String hersteller;
    private String modell;
    private String seriennummer;
    private String verfuegbarkeit;     // verfügbar, ausgeliehen, reserviert, in Wartung
    private String zustand;            // neu, gebraucht, defekt
}
