package cz.springframework.czpetclinic.services;

import cz.springframework.czpetclinic.model.Owner;
import cz.springframework.czpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
