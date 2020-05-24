package springframework.sfgpetclinic.services.map;

import springframework.sfgpetclinic.model.Vet;
import springframework.sfgpetclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstactMapService<Vet, Long> implements VetService {
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
        return super.save(vet.getId(), vet);
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

