package de.segoy.springframework.repositories;

import de.segoy.springframework.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
