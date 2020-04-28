package com.bliska.dinosauria.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Dinosaur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    @ManyToOne
    private Clade clade;
    @Lob
    private String description;
    @Enumerated(EnumType.STRING)
    private Epoch epoch;
    @OneToOne(cascade = CascadeType.ALL)
    private Size size;
    @Lob
    private byte[] image;
    @ManyToMany
    @JoinTable(name = "DINOSAUR_FOSSILE_SITE",
            joinColumns = @JoinColumn(name = "dinosaur_id"),
            inverseJoinColumns = @JoinColumn(name = "fossile_site_id"))
    Set<FossilSite> fossilSites = new HashSet<>();

    public void setSize(Size size) {
        if(size.getDinosaur() != null && !size.getDinosaur().equals(this)){
            size.setDinosaur(this);
        }
        this.size = size;
    }

    public Dinosaur addFossilSite(FossilSite fossilSite){
        fossilSite.getDinosaurs().add(this);
        fossilSites.add(fossilSite);
        return this;
    }

    public Dinosaur removeFossilSite(FossilSite fossilSite){
        fossilSite.getDinosaurs().remove(this);
        this.fossilSites.remove(fossilSite);
        return this;
    }
}
