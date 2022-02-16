package com.metrobuschallenge.controller;

import com.metrobuschallenge.entity.Alcaldia;
import com.metrobuschallenge.service.AlcaldiaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador principal para los servicios de alcaldias
 *
 * @author Jose Torrealba
 *
 */
@RestController
@RequestMapping(value = {"/codechallenge/api/v1/alcaldias"}, produces = {"application/json"})
public class AlcaldiaControllerImpl implements AlcaldiaController{
    private final AlcaldiaServiceImpl service;

    @Autowired
    public AlcaldiaControllerImpl(AlcaldiaServiceImpl service) {
        this.service = service;

    }
    @Override
    @Operation(
            summary = "Busca lista de alcaldia",
            description = "Busca lista de alcaldias por disponibilidad",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Respuesta a la request de alcaldia disponibles",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Alcaldia.class))
                            )
                    })
            }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = {RequestMethod.GET}, produces = {"application/json"})
    public List<Alcaldia> getAlcadiasDisponible() {
        return service.findAllByDisponible(true);
    }
}
