package springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.sfgpetclinic.model.Specialty;

public interface SpecialtiesRepository extends CrudRepository<Specialty, Long> {
}
