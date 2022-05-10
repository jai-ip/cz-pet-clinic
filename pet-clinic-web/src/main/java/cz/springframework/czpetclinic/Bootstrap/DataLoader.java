package cz.springframework.czpetclinic.Bootstrap;

import cz.springframework.czpetclinic.model.*;
import cz.springframework.czpetclinic.services.OwnerService;
import cz.springframework.czpetclinic.services.PetTypeService;
import cz.springframework.czpetclinic.services.SpecialtyService;
import cz.springframework.czpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args)throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        System.out.println("Pet Type Data Loaded....");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jai");
        owner1.setLastName("Hunter");
        owner1.setAddress("123 Chepauk");
        owner1.setCity("Chennai");
        owner1.setTelephone("132434355");

        Pet jaiPet = new Pet();
        jaiPet.setName("doggy");
        jaiPet.setOwner(owner1);
        jaiPet.setBirthDate(LocalDate.now());
        jaiPet.setPetType(dog);

        owner1.getPets().add(jaiPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Joe");
        owner2.setLastName("Rogan");
        owner2.setAddress("433 Utah");
        owner2.setCity("Texas");
        owner2.setTelephone("934434355");

        Pet joePet = new Pet();
        joePet.setName("catty");
        joePet.setOwner(owner2);
        joePet.setBirthDate(LocalDate.now());
        joePet.setPetType(cat);

        owner2.getPets().add(joePet);

        ownerService.save(owner2);

        System.out.println("Owner data Loaded.......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Captain");
        vet1.setLastName("Kirk");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dr.");
        vet2.setLastName("Paul");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Vet data Loaded........");
    }
}
