package com.metrobuschallenge.controller;

import com.metrobuschallenge.dto.AlcaldiaDto;

import java.util.List;
/**
 * Interface de controlador de alcaldias
 *
 * @author Jose Torrealba
 *
 */
public interface AlcaldiaController {
    List<AlcaldiaDto> getAlcadiasDisponible();
}
