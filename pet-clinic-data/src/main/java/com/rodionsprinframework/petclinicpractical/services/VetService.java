package com.rodionsprinframework.petclinicpractical.services;

import com.rodionsprinframework.petclinicpractical.model.Owner;
import com.rodionsprinframework.petclinicpractical.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Owner owner);

    Set<Vet> findAll();
}
