package de.segoy.springframework.services.map;

import de.segoy.springframework.model.Visit;
import de.segoy.springframework.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService <Visit,Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findall();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet()== null
                || object.getPet().getOwner()==null
                || object.getPet().getId()==null
                || object.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
