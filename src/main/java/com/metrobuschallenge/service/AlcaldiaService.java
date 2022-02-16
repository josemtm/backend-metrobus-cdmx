package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AlcaldiaService {
    Alcaldia save(Alcaldia object) throws Exception;

    Alcaldia update(Alcaldia object, String id) throws ObjectNotFoundException;

    Optional<Alcaldia> findOne(String id) throws ObjectNotFoundException;

    List<Alcaldia> findAll();

    List<Alcaldia> findAllByDisponible(Boolean disponible);

    List<Alcaldia> saveAll(List<Alcaldia> alcaldias);
}
