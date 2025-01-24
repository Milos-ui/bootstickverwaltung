package com.example.bootstickverwaltung.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stick_group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StickGroup {

    @Id
    @Column(name = "group_id")
    private String groupId;

    @Column(name = "stick_type")
    private String stickType;

    @Column(name = "number_of_sticks")
    private int numberOfSticks;

    /**
     * Verbindung zu den USBSticks,
     * damit du z.B. group.getSticks() abrufen kannst.
     */
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<USBStick> sticks = new ArrayList<>();
}
