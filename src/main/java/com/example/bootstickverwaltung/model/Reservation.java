package com.example.bootstickverwaltung.model;

import jakarta.persistence.*;
import lombok.*;

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
    private Long reservationId;  // Automatisch generiert

    /**
     * Jede Reservierung bezieht sich auf EINE Gruppe.
     * Will man alle Sticks dieser Reservierung einsehen,
     * kann man über reservation.getGroup().getSticks() zugreifen.
     */
    @ManyToOne
    @JoinColumn(name = "group_id")
    private StickGroup group;

    private String reservedBy;   // z.B. der Username oder E-Mail des Reservierenden
}
