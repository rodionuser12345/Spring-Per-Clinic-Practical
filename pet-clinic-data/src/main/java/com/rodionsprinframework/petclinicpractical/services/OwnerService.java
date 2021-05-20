package com.rodionsprinframework.petclinicpractical.services;

import com.rodionsprinframework.petclinicpractical.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
