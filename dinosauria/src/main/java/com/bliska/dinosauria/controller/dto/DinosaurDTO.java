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
    private List<String> fossilSites;

}
