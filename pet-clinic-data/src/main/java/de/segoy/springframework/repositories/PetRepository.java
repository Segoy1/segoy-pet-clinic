package de.segoy.springframework.repositories;

import de.segoy.springframework.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
