package com.bliska.dinosauria.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    public Dinosaur() {
    }

    public Dinosaur(String name, String description, Epoch epoch) {
        this.name = name;
        this.description = description;
        this.epoch = epoch;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Size getSize() {
        return size;
    }

    public Epoch getEpoch() {
        return epoch;
    }

    public void setEpoch(Epoch epoch) {
        this.epoch = epoch;
    }

    public void setSize(Size size) {
        if(size.getDinosaur() != null && !size.getDinosaur().equals(this)){
            size.setDinosaur(this);
        }
        this.size = size;
    }

    public Clade getClade() {
        return clade;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setClade(Clade clade) {
        this.clade = clade;
    }

    public Set<FossilSite> getFossilSites() {
        return fossilSites;
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

    public void setFossilSites(Set<FossilSite> fossilSites) {
        this.fossilSites = fossilSites;
    }

    @Override
    public String toString() {
        return "DinosaurDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
