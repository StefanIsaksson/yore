package com.bliska.dinosauria.controller.ws.dto;

import lombok.Data;

import java.util.List;

@Data
public class DinosaurDTO {

    private String name;
    private String clade;
    private String description;
    private String epoch;
    private Long height;
    private Long length;
    private Long weight;
    private List<String> fossileId;
    private List<String> fossilSites;

}
