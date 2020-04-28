package com.bliska.dinosauria.service;

import com.bliska.dinosauria.model.*;
import com.bliska.dinosauria.repository.CladeRepository;
import com.bliska.dinosauria.repository.DinosaurRepository;
import com.bliska.dinosauria.repository.FossilSiteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TyrannosaurursService {

    DinosaurRepository dinosaurRepository;
    CladeRepository cladeRepository;
    FossilSiteRepository fossilSiteRepository;

    public TyrannosaurursService(DinosaurRepository dinosaurRepository, CladeRepository cladeRepository, FossilSiteRepository fossilSiteRepository) {
        this.dinosaurRepository = dinosaurRepository;
        this.cladeRepository = cladeRepository;
        this.fossilSiteRepository = fossilSiteRepository;
    }

    @Transactional
    public void createTyrannosaurus() {

        Clade clade = getClade("Theropoda");

        FossilSite usa = getFossilSite("USA");
        FossilSite canada = getFossilSite("Canada");

        Dinosaur tyrannosaurus = new Dinosaur();
        tyrannosaurus.setName("Tyrannosaurus");
        tyrannosaurus.setDescription("The third largest meat-eating dinosaur of all time.");
        tyrannosaurus.setEpoch(Epoch.CRETACEOUS);
        tyrannosaurus.setSize(new Size(6L, 12L,140000L));

        tyrannosaurus.addFossilSite(usa);
        tyrannosaurus.addFossilSite(canada);

        fossilSiteRepository.save(usa);
        fossilSiteRepository.save(canada);

        clade.addDinosaur(tyrannosaurus);
        dinosaurRepository.save(tyrannosaurus);
    }

    private FossilSite getFossilSite(String name) {
        Optional<FossilSite> optionalFossilSite = fossilSiteRepository.findByName(name);
        if(optionalFossilSite.isPresent()){
            return optionalFossilSite.get();
        } else {
            FossilSite fossilSite = new FossilSite();
            fossilSite.setName(name);
            return fossilSite;
        }
    }

    private Clade getClade(String name) {
        Optional<Clade> cladeOptional = cladeRepository.findByName(name);
        if(cladeOptional.isPresent()){
            return cladeOptional.get();
        } else {
            Clade clade = new Clade();
            clade.setName(name);
            return clade;
        }
    }

}
