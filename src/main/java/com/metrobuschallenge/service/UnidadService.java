package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UnidadService {
    Unidad save(Unidad object) throws Exception;

    Optional<Unidad> findOne(String id) throws ObjectNotFoundException;

    List<Unidad> findAll();

    void deleteAll();
}
