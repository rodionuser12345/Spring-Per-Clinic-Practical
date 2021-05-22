package com.rodionsprinframework.petclinicpractical.bootstrap;

import com.rodionsprinframework.petclinicpractical.model.Owner;
import com.rodionsprinframework.petclinicpractical.model.PetType;
import com.rodionsprinframework.petclinicpractical.model.Vet;
import com.rodionsprinframework.petclinicpractical.services.OwnerService;
import com.rodionsprinframework.petclinicpractical.services.PetTypeService;
import com.rodionsprinframework.petclinicpractical.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Mitchel");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mike");
        owner2.setLastName("Paskin");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Johnas");
        vet1.setLastName("Mitchelas");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mikeas");
        vet2.setLastName("Paskinas");

        vetService.save(vet2);

        System.out.println("Loading vets...");

    }
}
