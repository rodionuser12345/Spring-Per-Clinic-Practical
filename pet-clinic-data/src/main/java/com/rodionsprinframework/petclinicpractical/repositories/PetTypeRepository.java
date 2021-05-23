package com.rodionsprinframework.petclinicpractical.repositories;

import com.rodionsprinframework.petclinicpractical.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
