package com.rodionsprinframework.petclinicpractical.services.map;

import com.rodionsprinframework.petclinicpractical.model.Pet;
import com.rodionsprinframework.petclinicpractical.services.PetService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {


    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
