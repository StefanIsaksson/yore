package com.bliska.dinosauria.repository;

import com.bliska.dinosauria.model.Clade;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CladeRepository extends CrudRepository<Clade, Long> {

    Optional<Clade> findByName(String name);
}
