package springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.sfgpetclinic.model.*;
import springframework.sfgpetclinic.services.PetTypeService;
import springframework.sfgpetclinic.services.SpecialtyService;
import springframework.sfgpetclinic.services.map.OwnerServiceMap;
import springframework.sfgpetclinic.services.map.SpecialtyServiceMap;
import springframework.sfgpetclinic.services.map.VetServiceMap;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    public final OwnerServiceMap ownerServiceMap;
    public final VetServiceMap vetServiceMap;
    public final PetTypeService petTypeService;
    public final SpecialtyServiceMap specialtyService;

    public DataLoader(OwnerServiceMap ownerServiceMap, VetServiceMap vetServiceMap, PetTypeService petTypeService, SpecialtyServiceMap specialtyService) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        specialtyService.save(dentistry);


        Owner o1 = new Owner();
        o1.setFirstName("Marek");
        o1.setLastName("Komasa");
        o1.setAddress("Warszawska 1");
        o1.setCity("Kraków");
        o1.setTelephone("123546547");
        ownerServiceMap.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Juliusz");
        o2.setLastName("Czarnecki");
        o2.setAddress("Kurnicka 33");
        o2.setCity("Oświęcim");
        o2.setTelephone("465467123");
        ownerServiceMap.save(o2);

        Pet adriansPet = new Pet();
        adriansPet.setOwner(o1);
        adriansPet.setBirthDate(LocalDate.of(2003, 11, 2));
        adriansPet.setName("Czaruś");
        adriansPet.setPetType(savedDogType);
        o1.getPets().add(adriansPet);

        Pet szymeksCat = new Pet();
        szymeksCat.setName("Czaruśka");
        szymeksCat.setBirthDate(LocalDate.of(2010, 3, 13));
        szymeksCat.setOwner(o2);
        szymeksCat.setPetType(savedCatType);

        Vet v1 = new Vet();
        v1.setFirstName("Jan");
        v1.setLastName("Popek");
        v1.getSpecialties().add(radiology);
        vetServiceMap.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Korneliusz");
        v2.setLastName("Knot");
        v2.getSpecialties().add(surgery);
        vetServiceMap.save(v2);

        Vet v3 = new Vet();
        v3.setFirstName("Stefan");
        v3.setLastName("Burczymucha");
        v3.getSpecialties().add(dentistry);
        vetServiceMap.save(v3);

        System.out.println("Loaded bootstrap data...");
    }
}
