package com.bliska.dinosauria.repository;

import com.bliska.dinosauria.model.Clade;
import com.bliska.dinosauria.model.FossilSite;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FossilSiteRepository extends CrudRepository<FossilSite, Long> {

    Optional<FossilSite> findByName(String name);

}
