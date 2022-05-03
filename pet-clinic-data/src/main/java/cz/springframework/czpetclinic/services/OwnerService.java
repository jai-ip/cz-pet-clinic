package cz.springframework.czpetclinic.services;

import cz.springframework.czpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

}
