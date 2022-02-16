package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.*;
import com.metrobuschallenge.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UnidadService {
    Unidad save(Unidad object) throws Exception;

    Optional<Unidad> findOne(String id) throws ObjectNotFoundException;

    List<Unidad> findAll();

    void deleteAll();

    List<Unidad> saveAll(List<Unidad> unidades);

    List<UnidadDto> findAllByDisponible(Boolean disponible);

    List<UnidadDto> findAllByAlcaldiaActual(String alcaldiaActual);

    String coordenadasUnidad(String id) throws ObjectNotFoundException;

    List<UnidadDto> listMapper(List<Unidad> unidades);
}
