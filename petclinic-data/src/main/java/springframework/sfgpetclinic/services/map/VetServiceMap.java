package springframework.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.sfgpetclinic.model.Specialty;
import springframework.sfgpetclinic.model.Vet;
import springframework.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstactMapService<Vet, Long> implements VetService {
    private final SpecialtyServiceMap specialtyServiceMap;

    public VetServiceMap(SpecialtyServiceMap specialtyServiceMap) {
        this.specialtyServiceMap = specialtyServiceMap;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {

        if (vet.getSpecialties().size() > 0){
            vet.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null){
                    Specialty savedSpecialty = specialtyServiceMap.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

