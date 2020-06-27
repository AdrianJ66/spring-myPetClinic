package springframework.sfgpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springframework.sfgpetclinic.model.Owner;
import springframework.sfgpetclinic.repositories.OwnerRepository;
import springframework.sfgpetclinic.repositories.PetRepository;
import springframework.sfgpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    final Long ownerId = 1L;
    final String lastName = "Jakiela";
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ownerId).lastName(lastName).build();
    }

    @Test
    void findByLastName() {


        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner returnedOwner = ownerRepository.findByLastName(lastName);

        assertEquals(lastName, returnedOwner.getLastName());
        verify(ownerRepository, times(1)).findByLastName(lastName);
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(2L).build());
        owners.add(owner);

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> returned = ownerSDJpaService.findAll();

        assertEquals(2, returned.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner returned =  ownerSDJpaService.findById(ownerId);
        assertNotNull(returned);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner returned =  ownerSDJpaService.findById(ownerId);
        assertNull(returned);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner returned = ownerSDJpaService.save(owner);
        assertNotNull(returned);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(2L);
        verify(ownerRepository,times(1)).deleteById(anyLong());
    }
}