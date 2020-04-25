package com.bliska.dinosauria.controller.dto;

import java.util.List;

public class DinosaurDTO {

    private String name;
    private String clade;
    private String description;
    private String epoch;
    private Long height;
    private Long length;
    private Long weight;
    private List<String> fossileSites;

    public DinosaurDTO(String name, String clade, String description, String epoch, Long height, Long length, Long weight, List<String> fossileSites) {
        this.name = name;
        this.clade = clade;
        this.description = description;
        this.epoch = epoch;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.fossileSites = fossileSites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClade() {
        return clade;
    }

    public void setClade(String clade) {
        this.clade = clade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
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

    public List<String> getFossileSites() {
        return fossileSites;
    }

    public void setFossileSites(List<String> fossileSites) {
        this.fossileSites = fossileSites;
    }
}
