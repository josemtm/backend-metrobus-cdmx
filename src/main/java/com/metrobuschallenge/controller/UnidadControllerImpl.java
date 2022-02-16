package com.metrobuschallenge.controller;

import com.metrobuschallenge.dto.UnidadDto;
import com.metrobuschallenge.exception.ObjectNotFoundException;
import com.metrobuschallenge.service.UnidadServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador principal para los servicios de unidades
 *
 * @author Jose Torrealba
 *
 */
@RestController
@RequestMapping(value = {"/codechallenge/api/v1/unidades"}, produces = {"application/json"})
public class UnidadControllerImpl implements UnidadController{
    private final UnidadServiceImpl service;

    @Autowired
    public UnidadControllerImpl(UnidadServiceImpl service) {
        this.service = service;

    }
    @Override
    @Operation(
            summary = "Busca lista de unidades",
            description = "Busca lista de unidades por disponibilidad",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Respuesta a la request de unidades disponibles",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = UnidadDto.class))
                            )
                    })
            }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = {"/disponibles"} ,method = {RequestMethod.GET}, produces = {"application/json"})
    public List<UnidadDto> getUnidadesDisponibles() {
        return service.findAllByDisponible(true);
    }

    @Override
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "404", description = "Object not found",
                    content = @Content) })
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = {"/ubicacionporid/{id}"} ,method = {RequestMethod.GET}, produces = {"application/json"})
    public String ubicacionPorId(@PathVariable String id) throws ObjectNotFoundException {
        return this.service.coordenadasUnidad(id);
    }

    @Override
    @Operation(
            summary = "Busca lista de unidades",
            description = "Busca lista de unidades por alcaldia",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Respuesta a la request de unidades por alcaldia",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = UnidadDto.class))
                            )
                    })
            }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = {RequestMethod.GET}, value = {"poralcaldia/{alcaldia}"}, produces = {"application/json"})
    public List<UnidadDto> getUnidadesPorAlcaldia(String alcaldia) {
        return this.service.findAllByAlcaldiaActual(alcaldia);
    }
}
