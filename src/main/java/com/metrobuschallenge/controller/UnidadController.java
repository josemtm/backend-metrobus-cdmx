package com.metrobuschallenge.controller;

import com.metrobuschallenge.entity.Coordenadas;
import com.metrobuschallenge.entity.Unidad;
import com.metrobuschallenge.exception.ObjectNotFoundException;

import java.util.List;

public interface UnidadController {
    List<Unidad> getUnidadesDisponibles();
    Coordenadas ubicacionPorId(String id) throws ObjectNotFoundException;
    List<Unidad> getUnidadesPorAlcaldia(String alcaldia);
}
