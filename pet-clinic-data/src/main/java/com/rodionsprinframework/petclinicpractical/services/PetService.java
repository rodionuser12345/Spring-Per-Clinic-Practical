package com.rodionsprinframework.petclinicpractical.services;

import com.rodionsprinframework.petclinicpractical.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
