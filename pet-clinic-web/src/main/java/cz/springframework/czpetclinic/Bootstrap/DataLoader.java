package cz.springframework.czpetclinic.Bootstrap;

import cz.springframework.czpetclinic.model.Owner;
import cz.springframework.czpetclinic.model.PetType;
import cz.springframework.czpetclinic.model.Vet;
import cz.springframework.czpetclinic.services.OwnerService;
import cz.springframework.czpetclinic.services.PetTypeService;
import cz.springframework.czpetclinic.services.VetService;
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
    public void run(String... args)throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println("Pet Type Data Loaded....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Jai");
        owner1.setLastName("Hunter");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Joe");
        owner2.setLastName("Rogan");

        ownerService.save(owner2);

        System.out.println("Owner data Loaded.......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Captain");
        vet1.setLastName("Kirk");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dr.");
        vet2.setLastName("Paul");

        vetService.save(vet2);

        System.out.println("Vet data Loaded........");
    }
}
