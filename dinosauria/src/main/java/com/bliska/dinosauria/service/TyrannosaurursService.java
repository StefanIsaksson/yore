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
        Dinosaur tyrannosaurus = new Dinosaur("Tyrannosaurus", "The third largest meat-eating dinosaur of all time.");

        tyrannosaurus.setEpoch(Epoch.CRETACEOUS);

        Size size = new Size(6L, 12L,140000L);
        size.setDinosaur(tyrannosaurus);
        tyrannosaurus.setSize(size);

        Optional<Clade> cladeOptional = cladeRepository.findByName("Theropoda");
        Clade clade = cladeOptional.orElse(new Clade("Theropoda"));
        tyrannosaurus.setClade(clade);

        Optional<FossilSite> usaOptional = fossileSiteRepository.findByName("USA");
        FossilSite usa = usaOptional.orElse(new FossilSite("USA"));
        usa.getDinosaurs().add(tyrannosaurus);
        tyrannosaurus.getFossilSites().add(usa);
        fossileSiteRepository.save(usa);

        Optional<FossilSite> canadaOptional = fossileSiteRepository.findByName("Canada");
        FossilSite canada = canadaOptional.orElse(new FossilSite("Canada"));
        canada.getDinosaurs().add(tyrannosaurus);
        tyrannosaurus.getFossilSites().add(canada);
        fossileSiteRepository.save(canada);

        dinosaurRepository.save(tyrannosaurus);
        clade.getDinosaurs().add(tyrannosaurus);
    }

}
