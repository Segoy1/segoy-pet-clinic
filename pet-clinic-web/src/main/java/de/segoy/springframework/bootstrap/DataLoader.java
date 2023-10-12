package de.segoy.springframework.bootstrap;

import de.segoy.springframework.model.Owner;
import de.segoy.springframework.model.Vet;
import de.segoy.springframework.services.OwnerService;
import de.segoy.springframework.services.VetService;
import de.segoy.springframework.services.map.OwnerServiceMap;
import de.segoy.springframework.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerService;
    private final VetServiceMap vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Klaus");
        owner1.setLastName("Lang");

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Hans");
        owner2.setLastName("Lang");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Peter");
        vet1.setLastName("Kurz");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Fritz");
        vet2.setLastName("Kurz");

        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
