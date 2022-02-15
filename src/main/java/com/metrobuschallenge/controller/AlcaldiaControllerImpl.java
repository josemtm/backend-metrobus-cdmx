package com.metrobuschallenge.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador principal para los servicios de alcaldias
 *
 * @author Jose Torrealba
 *
 */
@RestController
@RequestMapping(value = {"/codechallenge/api/v1/alcaldias"}, produces = {"application/json"})
public class AlcaldiaControllerImpl {
}
