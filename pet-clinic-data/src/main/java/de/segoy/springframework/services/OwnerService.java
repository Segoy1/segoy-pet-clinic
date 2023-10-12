package de.segoy.springframework.services;

import de.segoy.springframework.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
