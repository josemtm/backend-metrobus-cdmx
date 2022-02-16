package com.metrobuschallenge.service;

import com.metrobuschallenge.cdmxApi.UnidadRequest;
import com.metrobuschallenge.dto.UnidadDto;
import com.metrobuschallenge.entity.*;
import com.metrobuschallenge.exception.ObjectNotFoundException;
import com.vividsolutions.jts.io.ParseException;

import java.util.List;
import java.util.Optional;
/**
 * Interface de servicio de unidades
 *
 * @author Jose Torrealba
 *
 */
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

    List<Unidad> determinarEstadoUnidades(List<UnidadRequest> unidadesRequest, List<Alcaldia> alcaldias) throws ParseException;
}
