package com.bliska.dinosauria.controller.dto;

import lombok.Data;

import java.util.List;

public @Data class DinosaurDTO {

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

}
