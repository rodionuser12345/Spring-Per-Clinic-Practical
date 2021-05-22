package com.rodionsprinframework.petclinicpractical.bootstrap;

import com.rodionsprinframework.petclinicpractical.model.*;
import com.rodionsprinframework.petclinicpractical.services.OwnerService;
import com.rodionsprinframework.petclinicpractical.services.PetTypeService;
import com.rodionsprinframework.petclinicpractical.services.SpecialitiesService;
import com.rodionsprinframework.petclinicpractical.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0)
            loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialitiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Mitchel");
        owner1.setAddress("111 Bar Str.");
        owner1.setCity("Oklahoma");
        owner1.setTelephone("123123123");

        Pet dog1 = new Pet();
        dog1.setName("Doggy");
        dog1.setPetType(savedDogPetType);
        dog1.setOwner(owner1);
        dog1.setBirthDate(LocalDate.now());

        owner1.getPets().add(dog1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mike");
        owner2.setLastName("Paskin");
        owner2.setAddress("231 Swaters");
        owner2.setCity("Miami");
        owner2.setTelephone("167423754");

        Pet cat1 = new Pet();
        cat1.setName("Kitty");
        cat1.setPetType(savedCatPetType);
        cat1.setOwner(owner2);
        cat1.setBirthDate(LocalDate.now());

        owner2.getPets().add(cat1);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Johnas");
        vet1.setLastName("Mitchelas");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mikeas");
        vet2.setLastName("Paskinas");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loading vets...");
    }
}
