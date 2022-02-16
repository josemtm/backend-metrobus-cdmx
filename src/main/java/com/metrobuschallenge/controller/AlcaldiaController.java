package com.metrobuschallenge.controller;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.entity.AlcaldiaDto;

import java.util.List;

public interface AlcaldiaController {
    List<AlcaldiaDto> getAlcadiasDisponible();
}
