package com.rodionsprinframework.petclinicpractical.services.map;

import com.rodionsprinframework.petclinicpractical.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Long ownerId = 1L;

    String surname = "Hopkins";

//    @Mock
//    PetTypeService petTypeService;
//
//    @Mock
//    PetService petService;

    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(surname).build());

    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1,ownerSet.size());

    }

    @Test
    void deleteById() {

        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void delete() {

        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void saveExistingId() {

        long id = 2L;

        Owner ownerT = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(ownerT);

        assertEquals(id, savedOwner.getId());

    }

    @Test
    void saveNoId() {

        Owner saved = ownerMapService.save(Owner.builder().build());

        assertNotNull(saved);
        assertNotNull(saved.getId());

    }

    @Test
    void findById() {

        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {

        Owner found = ownerMapService.findByLastName(surname);

        assertNotNull(found);
        assertEquals(surname, found.getLastName());

    }

    @Test
    void findByLastNameNotFound() {

        Owner found = ownerMapService.findByLastName("foo");

        assertNull(found);

    }
}