package com.bliska.dinosauria.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class FossilSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "fossilSites")
    private Set<Dinosaur> dinosaurs = new HashSet<>();

    public FossilSite addDinosaur(Dinosaur dinosaur){
        dinosaur.getFossilSites().add(this);
        this.dinosaurs.add(dinosaur);
        return this;
    }

    public FossilSite removeDinosaur(Dinosaur dinosaur){
        dinosaur.getFossilSites().remove(this);
        this.dinosaurs.remove(dinosaur);
        return this;
    }

}
