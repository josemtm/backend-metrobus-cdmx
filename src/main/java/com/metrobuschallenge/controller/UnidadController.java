package com.metrobuschallenge.controller;

import com.metrobuschallenge.dto.UnidadDto;
import com.metrobuschallenge.exception.ObjectNotFoundException;

import java.util.List;
/**
 * Interface de controlador de unidades
 *
 * @author Jose Torrealba
 *
 */
public interface UnidadController {
    List<UnidadDto> getUnidadesDisponibles();
    String ubicacionPorId(String id) throws ObjectNotFoundException;
    List<UnidadDto> getUnidadesPorAlcaldia(String alcaldia);
}
