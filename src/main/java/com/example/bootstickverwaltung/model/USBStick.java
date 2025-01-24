package com.example.bootstickverwaltung.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usb_stick")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class USBStick {

    @Id
    @Column(name = "inventory_number")
    private String inventoryNumber;  // Eindeutig

    @ManyToOne
    @JoinColumn(name = "group_id")   // FK auf StickGroup
    private StickGroup group;

    @Column(name = "type")
    private String type; // z.B. Bootstick/Datenstick

    @Column(name = "storage_capacity")
    private String storageCapacity; // z.B. "16GB"

    private String manufacturer; // Hersteller
    private String model;        // Modell
    @Column(name = "serial_number")
    private String serialNumber;
    private String availability; // Verfügbar, Reserviert, etc.
    @Column(name = "stick_condition")  // <-- anpassen
    private String condition;          // Java-Feld darf "condition" heißen (nicht reserviert in Java).

    @ManyToOne
    @JoinColumn(name = "reservation_id") // FK auf Reservation
    private Reservation reservation;

}
