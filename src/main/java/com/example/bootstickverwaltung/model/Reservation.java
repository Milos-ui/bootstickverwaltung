package com.example.bootstickverwaltung.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    // Jede Reservierung bezieht sich auf EINE Gruppe
    @ManyToOne
    @JoinColumn(name = "group_id")
    private StickGroup group;

    @Column(name = "reserved_by")
    private String reservedBy;

    /**
     * Many-to-Many zwischen Reservation und USBStick
     * über die Join-Tabelle reservation_sticks.
     */
    @ManyToMany
    @JoinTable(
            name = "reservation_sticks",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "stick_id")
    )
    @ToString.Exclude
    private List<USBStick> sticks = new ArrayList<>();
}
