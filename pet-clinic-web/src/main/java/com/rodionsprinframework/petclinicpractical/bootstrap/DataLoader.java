package com.rodionsprinframework.petclinicpractical.bootstrap;

import com.rodionsprinframework.petclinicpractical.model.Owner;
import com.rodionsprinframework.petclinicpractical.model.Vet;
import com.rodionsprinframework.petclinicpractical.services.OwnerService;
import com.rodionsprinframework.petclinicpractical.services.VetService;
import com.rodionsprinframework.petclinicpractical.services.map.OwnerMapService;
import com.rodionsprinframework.petclinicpractical.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerMapService();
        this.vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Mitchel");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Mike");
        owner1.setLastName("Paskin");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Johnas");
        vet1.setLastName("Mitchelas");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mikeas");
        vet2.setLastName("Paskinas");

        vetService.save(vet2);

        System.out.println("Loading vets...");

    }
}
