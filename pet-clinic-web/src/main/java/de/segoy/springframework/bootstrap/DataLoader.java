package de.segoy.springframework.bootstrap;

import de.segoy.springframework.model.*;
import de.segoy.springframework.services.OwnerService;
import de.segoy.springframework.services.PetTypeService;
import de.segoy.springframework.services.SpecialtyService;
import de.segoy.springframework.services.VetService;
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
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            setUpData();
        }

    }

    private void setUpData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Klaus");
        owner1.setLastName("Lang");
        owner1.setAddress("Thunstrasse 2");
        owner1.setCity("Gwatt");
        owner1.setTelefone("+31 (79) 234 54 65");

        Pet klausPet = new Pet();
        klausPet.setPetType(savedDogType);
        klausPet.setBirthDate(LocalDate.now());
        klausPet.setName("Peter");
        owner1.getPets().add(klausPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Hans");
        owner2.setLastName("Lang");
        owner2.setAddress("Thunstrasse 3");
        owner2.setCity("Thun");
        owner2.setTelefone("+31 (79) 123 86 43");

        Pet hansPet = new Pet();
        hansPet.setPetType(savedCatType);
        hansPet.setBirthDate(LocalDate.now());
        hansPet.setName("Klaudia");
        owner2.getPets().add(hansPet);


        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Peter");
        vet1.setLastName("Kurz");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Fritz");
        vet2.setLastName("Kurz");
        vet2.getSpecialties().add(savedDentistry);
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
