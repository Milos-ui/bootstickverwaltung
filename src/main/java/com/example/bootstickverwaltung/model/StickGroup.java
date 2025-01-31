package com.example.bootstickverwaltung.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stick_group")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StickGroup {

    @Id
    private String groupId;

    private String stickType;

    // numberOfSticks NICHT mehr vom Request setzen lassen!
    private int numberOfSticks;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<USBStick> sticks = new ArrayList<>();

    // Helper-Methode, um numberOfSticks aus sticks.size() zu berechnen
    public void recalcStickCount() {
        this.numberOfSticks = (this.sticks == null) ? 0 : this.sticks.size();
    }
}
