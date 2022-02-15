package com.metrobuschallenge.controller;

import com.metrobuschallenge.entity.Unidad;

import java.util.List;

public interface UnidadController {
    List<Unidad> getUnidadesDisponibles();
    String ubicacionPorId(String id);
    List<Unidad> getUnidadesPorAlcaldia(String alcalda);
}
