package de.segoy.springframework.bootstrap;

import de.segoy.springframework.model.Owner;
import de.segoy.springframework.model.PetType;
import de.segoy.springframework.model.Vet;
import de.segoy.springframework.services.OwnerService;
import de.segoy.springframework.services.PetTypeService;
import de.segoy.springframework.services.VetService;
import de.segoy.springframework.services.map.OwnerServiceMap;
import de.segoy.springframework.services.map.VetServiceMap;
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
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Klaus");
        owner1.setLastName("Lang");

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Hans");
        owner2.setLastName("Lang");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Peter");
        vet1.setLastName("Kurz");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Fritz");
        vet2.setLastName("Kurz");

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
