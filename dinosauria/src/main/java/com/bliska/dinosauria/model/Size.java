package com.bliska.dinosauria.model;

import javax.persistence.*;

@Entity
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

    public Long getId() {
        return id;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Dinosaur getDinosaur() {
        return dinosaur;
    }

    public void setDinosaur(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }
}
