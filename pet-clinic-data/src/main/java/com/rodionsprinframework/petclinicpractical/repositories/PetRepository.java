package com.rodionsprinframework.petclinicpractical.repositories;

import com.rodionsprinframework.petclinicpractical.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
