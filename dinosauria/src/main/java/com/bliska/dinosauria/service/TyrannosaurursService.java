package com.bliska.dinosauria.service;

import com.bliska.dinosauria.model.*;
import com.bliska.dinosauria.repository.CladeRepository;
import com.bliska.dinosauria.repository.DinosaurRepository;
import com.bliska.dinosauria.repository.FossileSiteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TyrannosaurursService {

    DinosaurRepository dinosaurRepository;
    CladeRepository cladeRepository;
    FossileSiteRepository fossileSiteRepository;

    public TyrannosaurursService(DinosaurRepository dinosaurRepository, CladeRepository cladeRepository, FossileSiteRepository fossileSiteRepository) {
        this.dinosaurRepository = dinosaurRepository;
        this.cladeRepository = cladeRepository;
        this.fossileSiteRepository = fossileSiteRepository;
    }

    @Transactional
    public void saveTyrannosaurus() {

        Optional<Clade> cladeOptional = cladeRepository.findByName("Theropoda");
        Clade clade = cladeOptional.orElse(new Clade("Theropoda"));

        FossilSite usa = fossileSiteRepository.findByName("USA").orElse(new FossilSite("USA"));
        FossilSite canada = fossileSiteRepository.findByName("Canada").orElse(new FossilSite("Canada"));

        Dinosaur tyrannosaurus = new Dinosaur("Tyrannosaurus", "The third largest meat-eating dinosaur of all time.", Epoch.CRETACEOUS);
        tyrannosaurus.setSize(new Size(6L, 12L,140000L));

        tyrannosaurus.addFossilSite(usa).addFossilSite(canada).removeFossilSite(usa);

        fossileSiteRepository.save(usa);
        fossileSiteRepository.save(canada);

        clade.addDinosaur(tyrannosaurus);
        dinosaurRepository.save(tyrannosaurus);
    }

}
