package com.bliska.dinosauria.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Clade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clade")
    private Set<Dinosaur> dinosaurs;

    public Clade addDinosaur(@NonNull Dinosaur dinosaur){
        dinosaur.setClade(this);
        this.dinosaurs.add(dinosaur);
        return this;
    }

    public Clade removeDinosaur(@NonNull Dinosaur dinosaur){
        dinosaur.setClade(null);
        this.dinosaurs.remove(dinosaur);
        return this;
    }
}

