package com.bliska.dinosauria.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FossilSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "fossilSites")
    private Set<Dinosaur> dinosaurs = new HashSet<>();

    public FossilSite() {
    }

    public FossilSite(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
