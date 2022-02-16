package com.metrobuschallenge.controller;

import com.metrobuschallenge.entity.Coordenadas;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.entity.UnidadDto;
import com.metrobuschallenge.exception.ObjectNotFoundException;

import java.util.List;

public interface UnidadController {
    List<UnidadDto> getUnidadesDisponibles();
    String ubicacionPorId(String id) throws ObjectNotFoundException;
    List<UnidadDto> getUnidadesPorAlcaldia(String alcaldia);
}
