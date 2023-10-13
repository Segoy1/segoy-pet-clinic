package de.segoy.springframework.services.map;

import de.segoy.springframework.model.Owner;
import de.segoy.springframework.model.Pet;
import de.segoy.springframework.services.CrudService;
import de.segoy.springframework.services.OwnerService;
import de.segoy.springframework.services.PetService;
import de.segoy.springframework.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findall();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner != null){
            if (owner.getPets()!= null){
                owner.getPets().forEach(pet -> {
                    if(pet.getPetType()!=null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
        return super.save(owner);
        }
        else{
            return null;
        }
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
