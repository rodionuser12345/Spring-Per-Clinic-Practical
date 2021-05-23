package com.rodionsprinframework.petclinicpractical.services.jpa;

import com.rodionsprinframework.petclinicpractical.model.Owner;
import com.rodionsprinframework.petclinicpractical.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final String LAST_NAME = "Smith";

    Owner owner;

    public static final Long ID = 1L;

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJpaService ownerJpaService;

    @BeforeEach
    void setUp() {

        owner = Owner.builder().id(ID).lastName(LAST_NAME).build();

        ownerRepository.save(owner);
    }

    @Test
    void findAll() {

        Set<Owner> returnSet = new HashSet<>();
        returnSet.add(owner);
        returnSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnSet);

        Set<Owner> actualSet = ownerJpaService.findAll();

        assertNotNull(actualSet);
        assertEquals(actualSet.size(), returnSet.size());

        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.of(owner));

        Owner actualOwner = ownerJpaService.findById(ID);

        assertNotNull(actualOwner);

    }

    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.empty());

        Owner actualOwner = ownerJpaService.findById(ID);

        assertNull(actualOwner);

    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().id(ID).build();

        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        Owner savedOwner = ownerJpaService.save(ownerToSave);

        assertNotNull(savedOwner);
        assertEquals(savedOwner.getId(), ownerToSave.getId());

        verify(ownerRepository, times(2)).save(any());

    }

    @Test
    void delete() {

        ownerJpaService.delete(owner);

        assertEquals(0, ownerJpaService.findAll().size());

        verify(ownerRepository).delete(any());

    }

    @Test
    void deleteById() {

        ownerJpaService.deleteById(owner.getId());

        assertNull(ownerJpaService.findById(ID));

        verify(ownerRepository).deleteById(any());

    }

    @Test
    void findByLastName() {

        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = ownerJpaService.findByLastName(LAST_NAME);

        assertEquals(returnOwner.getLastName(), owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }
}