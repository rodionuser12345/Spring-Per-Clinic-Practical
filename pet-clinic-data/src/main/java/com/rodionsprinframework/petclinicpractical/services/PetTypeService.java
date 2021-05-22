package com.rodionsprinframework.petclinicpractical.services;

import com.rodionsprinframework.petclinicpractical.model.PetType;
import org.springframework.stereotype.Service;

@Service
public interface PetTypeService extends CrudService<PetType,Long> {
}
