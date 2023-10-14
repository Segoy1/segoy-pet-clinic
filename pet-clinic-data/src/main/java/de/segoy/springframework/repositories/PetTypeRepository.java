package de.segoy.springframework.repositories;

import de.segoy.springframework.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
