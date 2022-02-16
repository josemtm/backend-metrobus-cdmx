package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.Coordenadas;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UnidadService {
    Unidad save(Unidad object) throws Exception;

    Optional<Unidad> findOne(String id) throws ObjectNotFoundException;

    List<Unidad> findAll();

    void deleteAll();

    List<Unidad> saveAll(List<Unidad> unidades);

    List<Unidad> findAllByDisponible(Boolean disponible);

    List<Unidad> findAllByAlcaldiaActual(String alcaldiaActual);

    Coordenadas coordenadasUnidad(String id) throws ObjectNotFoundException;
}
