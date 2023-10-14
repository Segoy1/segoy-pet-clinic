package de.segoy.springframework.repositories;

import de.segoy.springframework.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
