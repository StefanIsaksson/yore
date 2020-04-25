package com.bliska.dinosauria.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Clade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clade")
    private Set<Dinosaur> dinosaurs;

    public Clade() {
    }

    public Clade(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public void setDinosaurs(Set<Dinosaur> dinosaurs) {
        this.dinosaurs = dinosaurs;
    }
}

