package sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.reactive.filter.OrderedWebFilter;
import springframework.sfgpetclinic.model.Owner;
import springframework.sfgpetclinic.model.Vet;
import springframework.sfgpetclinic.services.map.OwnerServiceMap;
import springframework.sfgpetclinic.services.map.PetServiceMap;
import springframework.sfgpetclinic.services.map.VetServiceMap;

public class DataLoader implements CommandLineRunner {

    public final OwnerServiceMap ownerServiceMap;
    public final VetServiceMap vetServiceMap;

    public DataLoader() {
        this.ownerServiceMap = new OwnerServiceMap();
        this.vetServiceMap = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner o1 = new Owner();
        o1.setFirstName("Marek");
        o1.setLastName("Komasa");
        o1.setId(1L);
        ownerServiceMap.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Juliusz");
        o2.setLastName("Czarnecki");
        o2.setId(2L);
        ownerServiceMap.save(o2);

        Vet v1 = new Vet();
        v1.setFirstName("Jan");
        v1.setLastName("Popek");
        v1.setId(1L);
        vetServiceMap.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Korneliusz");
        v2.setLastName("Knot");
        v2.setId(2L);
        vetServiceMap.save(v2);

        System.out.println("Loaded bootstrap data...");
    }
}
