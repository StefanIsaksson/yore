package com.bliska.dinosauria.repository;

import com.bliska.dinosauria.model.Dinosaur;
import org.springframework.data.repository.CrudRepository;

public interface DinosaurRepository extends CrudRepository<Dinosaur, Long> {

}
