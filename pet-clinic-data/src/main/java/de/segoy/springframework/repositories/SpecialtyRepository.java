package de.segoy.springframework.repositories;

import de.segoy.springframework.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
