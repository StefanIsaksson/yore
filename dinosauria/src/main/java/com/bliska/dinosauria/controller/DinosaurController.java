package com.bliska.dinosauria.controller;

import com.bliska.dinosauria.controller.dto.DinosaurDTO;
import com.bliska.dinosauria.model.Dinosaur;
import com.bliska.dinosauria.repository.DinosaurRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class DinosaurController {

    private DinosaurRepository repository;

    public DinosaurController(DinosaurRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public List<DinosaurDTO> getDinosaurs(){
        List<Dinosaur> entities = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(entities::add);

        List<DinosaurDTO> dinosaurs = entities.stream().map(x -> new DinosaurDTO(
                x.getName(),
                x.getClade().getName(),
                x.getDescription(),
                x.getEpoch().toString(),
                x.getSize().getHeight(),
                x.getSize().getLength(),
                x.getSize().getWeight(),
                x.getFossilSites().stream().map(y -> y.getName()).collect(Collectors.toList())
                )
        ).collect(Collectors.toList());

        return dinosaurs;
    }


}
