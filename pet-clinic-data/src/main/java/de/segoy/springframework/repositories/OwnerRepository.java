package de.segoy.springframework.repositories;

import de.segoy.springframework.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
