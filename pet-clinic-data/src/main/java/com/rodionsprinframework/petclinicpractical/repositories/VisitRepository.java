package com.rodionsprinframework.petclinicpractical.repositories;

import com.rodionsprinframework.petclinicpractical.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
