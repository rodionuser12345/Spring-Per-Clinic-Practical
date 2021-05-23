package com.rodionsprinframework.petclinicpractical.repositories;

import com.rodionsprinframework.petclinicpractical.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
