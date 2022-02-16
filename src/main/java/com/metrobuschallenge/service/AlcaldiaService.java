package com.metrobuschallenge.service;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.dto.AlcaldiaDto;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;
/**
 * Interface de servicio de alcaldias
 *
 * @author Jose Torrealba
 *
 */
public interface AlcaldiaService {
    Alcaldia save(Alcaldia object) throws Exception;

    Alcaldia update(Alcaldia object, String id) throws ObjectNotFoundException;

    Optional<Alcaldia> findOne(String id) throws ObjectNotFoundException;

    List<Alcaldia> findAll();

    List<AlcaldiaDto> findAllByDisponible(Boolean disponible);

    List<Alcaldia> saveAll(List<Alcaldia> alcaldias);

    List<AlcaldiaDto> listMapper(List<Alcaldia> alcaldias);

    void determinarEstadoAlcaldias(List<Alcaldia> alcaldias, List<Unidad> unidades);
}
