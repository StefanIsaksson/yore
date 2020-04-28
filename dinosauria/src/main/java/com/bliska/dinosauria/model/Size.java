package com.bliska.dinosauria.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Dinosaur dinosaur;
    private Long height;
    private Long length;
    private Long weight;

    public Size() {
    }

    public Size(Long height, Long length, Long weight) {
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public void setDinosaur(Dinosaur dinosaur) {
        if(dinosaur.getSize() != null && !dinosaur.getSize().equals(this)){
            dinosaur.setSize(this);
        }
        this.dinosaur = dinosaur;
    }
}
