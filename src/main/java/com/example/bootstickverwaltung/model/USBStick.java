package com.example.bootstickverwaltung.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usb_stick") // Name der Datenbank-Tabelle
public class USBStick {

    @Id
    private String inventarnummer;

    private String typ;            // Bootstick oder Datenstick
    private String speicherkapazitaet; // Größe des Speichers
    private String hersteller;     // Hersteller des USB-Sticks
    private String modell;         // Modellbezeichnung
    private String seriennummer;   // Seriennummer für Garantieansprüche
    private String verfuegbarkeit; // verfügbar, ausgeliehen, reserviert, in Wartung
    private String zustand;        // neu, gebraucht, defekt

    // Standard-Konstruktor (erforderlich für JPA)
    public USBStick() {
    }

    // Getter und Setter
    public String getInventarnummer() {
        return inventarnummer;
    }

    public void setInventarnummer(String inventarnummer) {
        this.inventarnummer = inventarnummer;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getSpeicherkapazitaet() {
        return speicherkapazitaet;
    }

    public void setSpeicherkapazitaet(String speicherkapazitaet) {
        this.speicherkapazitaet = speicherkapazitaet;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getSeriennummer() {
        return seriennummer;
    }

    public void setSeriennummer(String seriennummer) {
        this.seriennummer = seriennummer;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public void setVerfuegbarkeit(String verfuegbarkeit) {
        this.verfuegbarkeit = verfuegbarkeit;
    }

    public String getZustand() {
        return zustand;
    }

    public void setZustand(String zustand) {
        this.zustand = zustand;
    }
}
