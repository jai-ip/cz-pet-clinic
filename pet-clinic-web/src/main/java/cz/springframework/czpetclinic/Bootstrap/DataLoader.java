package cz.springframework.czpetclinic.Bootstrap;

import cz.springframework.czpetclinic.model.Owner;
import cz.springframework.czpetclinic.model.Vet;
import cz.springframework.czpetclinic.services.OwnerService;
import cz.springframework.czpetclinic.services.VetService;
import cz.springframework.czpetclinic.services.map.OwnerServiceMap;
import cz.springframework.czpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Jai");
        owner1.setLastName("Hunter");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Joe");
        owner2.setLastName("Rogan");

        ownerService.save(owner2);

        System.out.println("Owner data Loaded.......");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Captain");
        vet1.setLastName("Kirk");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet2.setFirstName("Dr.");
        vet2.setLastName("Paul");

        vetService.save(vet2);

        System.out.println("Vet data Loaded........");
    }
}